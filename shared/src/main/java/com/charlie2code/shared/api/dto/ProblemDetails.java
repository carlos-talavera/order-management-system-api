package com.charlie2code.shared.api.dto;

import java.time.Instant;

public record ProblemDetails(
        String title,
        int status,
        String detail,
        String instance,
        Instant timestamp
) {}
