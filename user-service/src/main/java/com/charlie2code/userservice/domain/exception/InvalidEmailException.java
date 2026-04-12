package com.charlie2code.userservice.domain.exception;

public class InvalidEmailException extends DomainException {
    public InvalidEmailException(String value) {
        super("Invalid email: " + value);
    }

    public InvalidEmailException(String message, Throwable cause) {
        super(message, cause);
    }
}
