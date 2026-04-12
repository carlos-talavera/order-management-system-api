package com.charlie2code.userservice.application.exception;

public class EmailAlreadyExistsException extends ApplicationException {
    public EmailAlreadyExistsException(String email) {
        super("Email already exists: " + email);
    }

    public EmailAlreadyExistsException(String message, Throwable cause) {
        super(message, cause);
    }
}
