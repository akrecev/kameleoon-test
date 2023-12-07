package com.kretsev.test_task.vote.repository;

import com.kretsev.test_task.vote.model.Vote;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Collection;

public interface VoteRepository extends JpaRepository<Vote, Long> {
    Page<Vote> findByIdIn(Collection<Long> ids, Pageable pageable);

}
