package com.kretsev.test_task.quote.service.impl;

import com.kretsev.test_task.exception.DataNotFoundException;
import com.kretsev.test_task.quote.dto.NewQuoteRequest;
import com.kretsev.test_task.quote.dto.QuoteDto;
import com.kretsev.test_task.quote.model.Quote;
import com.kretsev.test_task.quote.repository.QuoteRepository;
import com.kretsev.test_task.quote.service.QuoteService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static com.kretsev.test_task.quote.mapper.QuoteMapper.toNewQuote;
import static com.kretsev.test_task.quote.mapper.QuoteMapper.toQuoteDto;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class QuoteServiceImpl implements QuoteService {
    private final QuoteRepository quoteRepository;

    @Override
    @Transactional
    public QuoteDto create(NewQuoteRequest quoteRequest) {
        Quote quote = quoteRepository.save(toNewQuote(quoteRequest));

        return toQuoteDto(quote);
    }

    @Override
    public QuoteDto getQuote(Long quoteId) {
        return toQuoteDto(
                quoteRepository.findById(quoteId).orElseThrow(() -> new DataNotFoundException("Quote", quoteId))
        );
    }

    @Override
    public QuoteDto getRandomQuote() {
        return null;
    }

    @Override
    public List<QuoteDto> getQuotes(List<Long> ids, Integer from, Integer size) {
        return null;
    }

    @Override
    public List<QuoteDto> getTopQuotes() {
        return null;
    }

    @Override
    public List<QuoteDto> getWorseQuotes() {
        return null;
    }

    @Override
    public List<Integer> getEvolutionQuotes() {
        return null;
    }

    @Override
    @Transactional
    public QuoteDto update(NewQuoteRequest quoteRequest) {
        return null;
    }

    @Override
    @Transactional
    public void deleteById(Long quoteId) {

    }
}
