package com.charlie2code.userservice.application.dto.createuser;

import jakarta.validation.constraints.NotBlank;

public record CreateUserResult(
        @NotBlank(message = "ID is required")
        String id
) {}
