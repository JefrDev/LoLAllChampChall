package com.jefr.RandomRiftRoulette.common.dtos;

import jakarta.validation.constraints.*;

public record UserRegistrationDTO(
        @Size(min = 4,  max = 15, message = "Username must be between 4 and 15 characters long")
        String username,
        @Email
        String email,
        @Size(min = 7, max = 15, message = "Password must be between 7 and 15 characters long")
        String password
) {}
