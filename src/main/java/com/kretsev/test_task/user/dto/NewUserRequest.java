package com.kretsev.test_task.user.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class NewUserRequest {
    @NotBlank
    @Length(max = 255)
    private String name;

    @NotBlank
    @Email
    @Length(max = 512)
    private String email;

    @NotBlank
    @Length(max = 512)
    private String password;
}
