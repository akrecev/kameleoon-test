package com.kretsev.test_task.vote.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class VoteShortDto {
    private Boolean positive;
    private LocalDateTime created;
}
