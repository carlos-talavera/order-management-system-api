package com.charlie2code.userservice.domain.exception;

public class InvalidUserIdException extends DomainException {
    public InvalidUserIdException(String value) {
        super("Invalid UserId: " + value);
    }

    public InvalidUserIdException(String message, Throwable cause) {
        super(message, cause);
    }
}
