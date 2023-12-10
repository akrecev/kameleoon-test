package com.kretsev.test_task.rest;

import com.kretsev.test_task.quote.dto.QuoteFullDto;
import com.kretsev.test_task.quote.service.QuoteService;
import com.kretsev.test_task.user.dto.NewUserRequest;
import com.kretsev.test_task.user.dto.UserDto;
import com.kretsev.test_task.user.service.UserService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Positive;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.Map;

@Slf4j
@RestController
@RequiredArgsConstructor
@Validated
@RequestMapping("api/v1/admin")
public class AdminController {
    private final QuoteService quoteService;
    private final UserService userService;

    @PostMapping("/users")
    public ResponseEntity<UserDto> createUser(@Valid @RequestBody NewUserRequest userRequest) {
        log.info("Create user {}", userRequest);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(userService.create(userRequest));
    }

    @GetMapping("/quotes/{quoteId}")
    public ResponseEntity<QuoteFullDto> getQuote(
            @Positive @PathVariable Long quoteId
    ) {
        log.info("Get quote id={}", quoteId);

        return ResponseEntity.ok(quoteService.getQuote(quoteId));
    }

    @GetMapping("/quotes/{quoteId}/evolution")
    public ResponseEntity<Map<LocalDate, Long>> getEvolutionRating(
            @Positive @PathVariable Long quoteId
    ) {
        log.info("Get evolution rating for quote id={}", quoteId);

        return ResponseEntity.ok(quoteService.getEvolutionRating(quoteId));
    }

}
