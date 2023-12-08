package com.kretsev.test_task.vote.service;

import com.kretsev.test_task.vote.dto.NewVoteRequest;
import com.kretsev.test_task.vote.dto.VoteDto;

public interface VoteService {
    VoteDto create(NewVoteRequest voteRequest, Long voterId, Long quoteId);

    void delete(Long id, Long voterId);
}
