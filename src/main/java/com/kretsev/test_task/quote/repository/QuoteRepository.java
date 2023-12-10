package com.kretsev.test_task.quote.repository;

import com.kretsev.test_task.quote.model.Quote;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface QuoteRepository extends JpaRepository<Quote, Long> {
    @Query(value = "SELECT * FROM quotes ORDER BY random() limit 1",
            nativeQuery = true)
    Optional<Quote> findRandom();

    @Query("SELECT q FROM Quote q ORDER BY " +
            "(SELECT COUNT(v.positive) - COUNT(v.negative) FROM Vote v WHERE  v.quote = q) DESC " +
            "LIMIT 10")
    List<Quote> findTopQuotes();

    @Query("SELECT q FROM Quote q ORDER BY " +
            "(SELECT COUNT(v.negative) - COUNT(v.positive) FROM Vote v WHERE  v.quote = q) DESC " +
            "LIMIT 10")
    List<Quote> findWorseQuotes();

}
