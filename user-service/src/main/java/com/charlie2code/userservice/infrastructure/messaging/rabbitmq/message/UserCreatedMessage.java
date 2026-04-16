package com.charlie2code.userservice.infrastructure.messaging.rabbitmq.message;

public record UserCreatedMessage(
    String authId,
    String firstName,
    String lastName,
    String email
) {}
