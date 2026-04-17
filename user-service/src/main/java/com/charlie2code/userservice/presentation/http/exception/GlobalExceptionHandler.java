package com.charlie2code.userservice.presentation.http.exception;

import com.charlie2code.userservice.application.exception.ApplicationException;
import com.charlie2code.userservice.domain.exception.DomainException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import com.charlie2code.shared.api.dto.ProblemDetails;

import jakarta.servlet.http.HttpServletRequest;
import java.time.Instant;

@RestControllerAdvice
public class GlobalExceptionHandler {

    private static final Logger log = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    private ResponseEntity<ProblemDetails> buildResponse(Exception ex, HttpStatus status, HttpServletRequest request) {
        ProblemDetails body = new ProblemDetails(
                ex.getClass().getSimpleName(),
                status.value(),
                ex.getMessage(),
                request.getRequestURI(),
                Instant.now()
        );
        return new ResponseEntity<>(body, status);
    }

    @ExceptionHandler(DomainException.class)
    public ResponseEntity<ProblemDetails> handleDomain(DomainException ex, HttpServletRequest request) {
        log.warn("Domain error at [{}]: {}", request.getRequestURI(), ex.getMessage());
        return buildResponse(ex, HttpStatus.BAD_REQUEST, request);
    }

    @ExceptionHandler(ApplicationException.class)
    public ResponseEntity<ProblemDetails> handleApplication(ApplicationException ex, HttpServletRequest request) {
        log.warn("Application error at [{}]: {}", request.getRequestURI(), ex.getMessage());
        return buildResponse(ex, HttpStatus.BAD_REQUEST, request);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ProblemDetails> handleOther(Exception ex, HttpServletRequest request) {
        log.error("Unexpected error at [{}]", request.getRequestURI(), ex);
        return buildResponse(ex, HttpStatus.INTERNAL_SERVER_ERROR, request);
    }
}
