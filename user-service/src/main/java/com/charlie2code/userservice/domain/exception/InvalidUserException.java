package com.charlie2code.userservice.domain.exception;

public class InvalidUserException extends DomainException {
    public InvalidUserException(String message) {
        super("Invalid user: " + message);
    }

    public InvalidUserException(String message, Throwable cause) {
        super(message, cause);
    }
}
