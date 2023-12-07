package com.kretsev.test_task.quote.repository;

import com.kretsev.test_task.quote.model.Quote;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Collection;

public interface QuoteRepository extends JpaRepository<Quote, Long> {
    Page<Quote> findByIdIn(Collection<Long> ids, Pageable pageable);

}
