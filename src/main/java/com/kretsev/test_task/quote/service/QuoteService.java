package com.kretsev.test_task.quote.service;

import com.kretsev.test_task.quote.dto.NewQuoteRequest;
import com.kretsev.test_task.quote.dto.QuoteDto;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

public interface QuoteService {
    QuoteDto create(NewQuoteRequest quoteRequest, Long speakerId);

    QuoteDto getQuote(Long quoteId);

    QuoteDto getRandomQuote();

    List<QuoteDto> getQuotes(List<Long> ids, Integer from, Integer size);

    List<QuoteDto> getTopQuotes();

    List<QuoteDto> getWorseQuotes();

    Map<LocalDate, Long> getEvolutionQuotes(Long quoteId);

    QuoteDto update(NewQuoteRequest quoteRequest, Long speakerId, Long quoteId);

    void deleteById(Long quoteId);
}
