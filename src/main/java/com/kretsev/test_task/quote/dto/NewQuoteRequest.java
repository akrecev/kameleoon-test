package com.kretsev.test_task.quote.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class NewQuoteRequest {
    @NotBlank
    @Length(max = 3000)
    private String content;

    @NotNull
    private Long speakerId;
}
