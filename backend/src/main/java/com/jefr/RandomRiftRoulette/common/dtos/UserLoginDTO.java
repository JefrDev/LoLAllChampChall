package com.jefr.RandomRiftRoulette.common.dtos;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Size;

public record UserLoginDTO(
        @Email
        String email,
        @Size(min = 7, max = 15, message = "Password must be between 7 and 15 characters long")
        String password
) {
}
