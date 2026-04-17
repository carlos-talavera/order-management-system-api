package com.charlie2code.userservice.application.messaging.usercreated;

public record UserCreatedInput(
        String authId,
        String email,
        String firstName,
        String lastName
) {}
