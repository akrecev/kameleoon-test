package com.kretsev.test_task.quote.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.kretsev.test_task.user.dto.UserShortDto;
import com.kretsev.test_task.vote.dto.VoteShortDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class QuoteDto {
    private Long id;
    private String content;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime created;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime updated;
    private UserShortDto speaker;
    private List<VoteShortDto> votes;
}
