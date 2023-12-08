package com.kretsev.test_task.vote.service.impl;

import com.kretsev.test_task.exception.ConflictException;
import com.kretsev.test_task.exception.DataNotFoundException;
import com.kretsev.test_task.quote.model.Quote;
import com.kretsev.test_task.quote.repository.QuoteRepository;
import com.kretsev.test_task.user.model.User;
import com.kretsev.test_task.user.repository.UserRepository;
import com.kretsev.test_task.vote.dto.NewVoteRequest;
import com.kretsev.test_task.vote.dto.VoteDto;
import com.kretsev.test_task.vote.model.Vote;
import com.kretsev.test_task.vote.repository.VoteRepository;
import com.kretsev.test_task.vote.service.VoteService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.Objects;

import static com.kretsev.test_task.vote.mapper.VoteMapper.toNewVote;
import static com.kretsev.test_task.vote.mapper.VoteMapper.toVoteDto;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class VoteServiceImpl implements VoteService {
    private final UserRepository userRepository;
    private final QuoteRepository quoteRepository;
    private final VoteRepository voteRepository;

    @Override
    public VoteDto create(NewVoteRequest voteRequest, Long voterId, Long quoteId) {
        User voter = userRepository.findById(voterId).orElseThrow(() -> new DataNotFoundException("User", voterId));
        Quote quote = quoteRepository.findById(quoteId).orElseThrow(() -> new DataNotFoundException("Quote", quoteId));
        if (Objects.equals(quote.getSpeaker().getId(), voterId)) {
            throw new ConflictException("The author of the quote cannot vote!");
        }
        Vote vote = toNewVote(voteRequest);
        vote.setCreated(LocalDateTime.now());
        vote.setVoter(voter);
        vote.setQuote(quote);

        return toVoteDto(voteRepository.save(vote));
    }

    @Override
    public void delete(Long id, Long voterId) {
        Vote vote = voteRepository.findById(id).orElseThrow(() -> new DataNotFoundException("Vote", id));
        if (!Objects.equals(vote.getVoter().getId(), voterId)) {
            throw new ConflictException("Only the author of the vote can delete it");
        }
        voteRepository.deleteById(id);
    }
}
