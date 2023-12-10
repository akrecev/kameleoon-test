package com.kretsev.test_task.rest;

import com.kretsev.test_task.quote.dto.QuoteDto;
import com.kretsev.test_task.quote.service.QuoteService;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1")
public class PublicController {
    private final QuoteService quoteService;

    @GetMapping("/quotes/all")
    public ResponseEntity<List<QuoteDto>> getAllQuotes(
            @PositiveOrZero @RequestParam(value = "from", defaultValue = "0") Integer from,
            @Positive @RequestParam(value = "size", defaultValue = "10") Integer size
    ) {
        log.info("Get quotes");

        return ResponseEntity.ok(quoteService.getQuotes(from, size));
    }

    @GetMapping("/quotes/random")
    public ResponseEntity<QuoteDto> getRandomQuote() {
        log.info("Get random quote");

        return ResponseEntity.ok(quoteService.getRandomQuote());
    }

    @GetMapping("/quotes/top")
    public ResponseEntity<List<QuoteDto>> getTopQuotes() {
        log.info("Get top quotes");

        return ResponseEntity.ok(quoteService.getTopQuotes());
    }

    @GetMapping("/quotes/worse")
    public ResponseEntity<List<QuoteDto>> getWorseQuotes() {
        log.info("Get worse quotes");

        return ResponseEntity.ok(quoteService.getWorseQuotes());
    }
}
