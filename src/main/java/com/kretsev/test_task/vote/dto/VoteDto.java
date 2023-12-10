package com.kretsev.test_task.vote.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.kretsev.test_task.quote.dto.QuoteDto;
import com.kretsev.test_task.user.dto.UserDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class VoteDto {
    private Long id;
    private Boolean positive;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime created;
    private UserDto voter;
    private QuoteDto quote;
}
