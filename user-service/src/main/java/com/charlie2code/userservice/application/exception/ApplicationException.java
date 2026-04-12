package com.charlie2code.userservice.application.exception;

public class ApplicationException extends RuntimeException {
    public ApplicationException(String message) {
        super(message);
    }

    protected ApplicationException(String message, Throwable cause) { super(message, cause ); }
}
