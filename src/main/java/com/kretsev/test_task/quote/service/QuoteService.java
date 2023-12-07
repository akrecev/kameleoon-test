package com.kretsev.test_task.quote.service;

import com.kretsev.test_task.quote.dto.NewQuoteRequest;
import com.kretsev.test_task.quote.dto.QuoteDto;

import java.util.List;

public interface QuoteService {
    QuoteDto create(NewQuoteRequest quoteRequest);
    QuoteDto getQuote(Long quoteId);
    QuoteDto getRandomQuote();
    List<QuoteDto> getQuotes(List<Long> ids, Integer from, Integer size);
    List<QuoteDto> getTopQuotes();
    List<QuoteDto> getWorseQuotes();
    List<Integer> getEvolutionQuotes();
    QuoteDto update(NewQuoteRequest quoteRequest);
    void deleteById(Long quoteId);
}
