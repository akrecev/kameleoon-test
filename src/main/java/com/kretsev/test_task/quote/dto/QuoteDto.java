package com.kretsev.test_task.quote.dto;

import com.kretsev.test_task.user.dto.UserDto;
import com.kretsev.test_task.vote.dto.VoteShortDto;
import com.kretsev.test_task.vote.model.Vote;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class QuoteDto {
    private Long id;
    private String content;
    private LocalDateTime created;
    private LocalDateTime updated;
    private UserDto speaker;
    private Set<VoteShortDto> votes;
}