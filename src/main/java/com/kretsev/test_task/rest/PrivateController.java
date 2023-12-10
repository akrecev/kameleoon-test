package com.kretsev.test_task.rest;

import com.kretsev.test_task.quote.dto.NewQuoteRequest;
import com.kretsev.test_task.quote.dto.QuoteFullDto;
import com.kretsev.test_task.quote.service.QuoteService;
import com.kretsev.test_task.vote.dto.NewVoteRequest;
import com.kretsev.test_task.vote.dto.VoteDto;
import com.kretsev.test_task.vote.service.VoteService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Positive;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/users")
public class PrivateController {
    private final QuoteService quoteService;
    private final VoteService voteService;

    @PostMapping("/{userId}/quotes")
    public ResponseEntity<QuoteFullDto> createQuote(
            @Positive @PathVariable Long userId,
            @Valid @RequestBody NewQuoteRequest quoteRequest
    ) {
        log.info("Create quote {}", quoteRequest);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(quoteService.create(quoteRequest, userId));
    }

    @PostMapping("/{userId}/quotes/{quoteId}/votes")
    public ResponseEntity<VoteDto> createVote(
            @Positive @PathVariable Long userId,
            @Positive @PathVariable Long quoteId,
            @Valid @RequestBody NewVoteRequest voteRequest
    ) {
        log.info("Create vote {}", voteRequest);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(voteService.create(voteRequest, userId, quoteId));
    }

}
