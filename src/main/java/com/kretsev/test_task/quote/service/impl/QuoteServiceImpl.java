package com.kretsev.test_task.quote.service.impl;

import com.kretsev.test_task.exception.ConflictException;
import com.kretsev.test_task.exception.DataNotFoundException;
import com.kretsev.test_task.quote.dto.NewQuoteRequest;
import com.kretsev.test_task.quote.dto.QuoteDto;
import com.kretsev.test_task.quote.dto.QuoteFullDto;
import com.kretsev.test_task.quote.mapper.QuoteMapper;
import com.kretsev.test_task.quote.model.Quote;
import com.kretsev.test_task.quote.repository.QuoteRepository;
import com.kretsev.test_task.quote.service.QuoteService;
import com.kretsev.test_task.user.repository.UserRepository;
import com.kretsev.test_task.utility.MyPageRequest;
import com.kretsev.test_task.vote.model.Vote;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.*;
import java.util.stream.Collectors;

import static com.kretsev.test_task.quote.mapper.QuoteMapper.*;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class QuoteServiceImpl implements QuoteService {
    private final QuoteRepository quoteRepository;
    private final UserRepository userRepository;

    @Override
    @Transactional
    public QuoteFullDto create(NewQuoteRequest quoteRequest, Long speakerId) {
        Quote quote = toNewQuote(quoteRequest);
        quote.setSpeaker(userRepository.findById(speakerId)
                .orElseThrow(() -> new DataNotFoundException("User", speakerId)));
        quote.setCreated(LocalDateTime.now());

        return toQuoteFullDto(quoteRepository.save(quote));
    }

    @Override
    public QuoteFullDto getQuote(Long id) {
        Quote quote = quoteRepository.findById(id).orElseThrow(() -> new DataNotFoundException("Quote", id));

        return toQuoteFullDto(
                quote
        );
    }

    @Override
    public QuoteDto getRandomQuote() {
        return toQuoteDto(quoteRepository.findRandom().orElseThrow(() -> new DataNotFoundException("Quote not found")));
    }

    @Override
    public List<QuoteDto> getQuotes(Integer from, Integer size) {
        return quoteRepository.findAll(new MyPageRequest(from, size)).stream()
                .map(QuoteMapper::toQuoteDto)
                .collect(Collectors.toList());
    }

    @Override
    public List<QuoteDto> getTopQuotes() {
        return quoteRepository.findTopQuotes().stream().map(QuoteMapper::toQuoteDto).collect(Collectors.toList());
    }

    @Override
    public List<QuoteDto> getWorseQuotes() {
        return quoteRepository.findWorseQuotes().stream().map(QuoteMapper::toQuoteDto).collect(Collectors.toList());
    }

    @Override
    public Map<LocalDate, Long> getEvolutionRating(Long id) {
        Map<LocalDate, Long> evolutionRating = new TreeMap<>();
        Quote quote = quoteRepository.findById(id).orElseThrow(() -> new DataNotFoundException("Quote", id));
        Set<Vote> votes = quote.getVotes();
        for (Vote vote : votes) {
            if (vote.getPositive() != null && vote.getPositive()) {
                if (evolutionRating.containsKey(vote.getCreated().toLocalDate())) {
                    evolutionRating.put(
                            vote.getCreated().toLocalDate(), evolutionRating.get(vote.getCreated().toLocalDate()) + 1L
                    );
                } else {
                    evolutionRating.put(vote.getCreated().toLocalDate(), 1L);
                }
            } else if (vote.getNegative() != null && vote.getNegative()) {
                if (evolutionRating.containsKey(vote.getCreated().toLocalDate())) {
                    evolutionRating.put(
                            vote.getCreated().toLocalDate(), evolutionRating.get(vote.getCreated().toLocalDate()) - 1L
                    );
                } else {
                    evolutionRating.put(vote.getCreated().toLocalDate(), -1L);
                }
            }
        }

        return evolutionRating;
    }

    @Override
    @Transactional
    public QuoteDto update(NewQuoteRequest quoteRequest, Long speakerId, Long quoteId) {
        Quote quote = quoteRepository.findById(quoteId).orElseThrow(() -> new DataNotFoundException("Quote", quoteId));
        if (!Objects.equals(quote.getSpeaker().getId(), speakerId)) {
            throw new ConflictException("User id=" + speakerId + "has no right to change this quote!");
        }
        if (!quoteRequest.getContent().equals(quote.getContent())) {
            quote.setContent(quoteRequest.getContent());
            quote.setUpdated(LocalDateTime.now());
            quote = quoteRepository.save(quote);
        }

        return toQuoteDto(quote);
    }

    @Override
    @Transactional
    public void delete(Long id) {
        quoteRepository.deleteById(id);
    }

}
