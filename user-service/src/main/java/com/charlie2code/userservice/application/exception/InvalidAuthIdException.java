package com.charlie2code.userservice.application.exception;

public class InvalidAuthIdException extends ApplicationException {
    public InvalidAuthIdException(String value) {
        super("Invalid auth ID: " + value);
    }

    public InvalidAuthIdException(String message, Throwable cause) {
        super(message, cause);
    }
}
