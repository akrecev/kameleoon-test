package com.kretsev.test_task.quote.dto;

import com.kretsev.test_task.user.model.User;
import com.kretsev.test_task.vote.model.Vote;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class QuoteShortDto {
    private String content;
}
