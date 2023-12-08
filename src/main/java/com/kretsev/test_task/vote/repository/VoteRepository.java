package com.kretsev.test_task.vote.repository;

import com.kretsev.test_task.vote.model.Vote;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface VoteRepository extends JpaRepository<Vote, Long> {
    List<Vote> findByQuoteId(Long quoteId);

}
