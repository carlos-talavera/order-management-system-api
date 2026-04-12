package com.charlie2code.userservice.application.dto.createuser;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record CreateUserRequest(
        @NotBlank(message = "Auth ID is required")
        String authId,

        @NotBlank(message = "First name is required")
        @Size(min = 2, max = 40)
        String firstName,

        @NotBlank(message = "Last name is required")
        @Size(min = 2, max = 40)
        String lastName,

        @NotBlank(message = "Email is required")
        @Email(message = "Email must be valid")
        String email
) {}
