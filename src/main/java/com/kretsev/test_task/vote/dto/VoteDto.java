package com.kretsev.test_task.vote.dto;

import com.kretsev.test_task.quote.model.Quote;
import com.kretsev.test_task.user.model.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class VoteDto {
    private Long id;
    private Boolean isPositive;
    private LocalDateTime created;
    private User voter;
    private Quote quote;
}
