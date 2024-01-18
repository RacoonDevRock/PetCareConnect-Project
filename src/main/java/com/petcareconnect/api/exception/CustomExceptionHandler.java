package com.petcareconnect.api.exception;

import com.petcareconnect.api.exception.dto.ErrorMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;

@RestControllerAdvice
public class CustomExceptionHandler {
    private static final Logger log = LoggerFactory.getLogger(CustomExceptionHandler.class);

    @ExceptionHandler(value = { NoSuchElementException.class })
    public ResponseEntity<ErrorMessage> noSuchElementException(NoSuchElementException e) {
        log.error(e.getMessage(), e.getCause());
        ErrorMessage errorMessage = new ErrorMessage(LocalDateTime.now(), HttpStatus.INTERNAL_SERVER_ERROR.value(), e.getMessage());
        return new ResponseEntity<>(errorMessage, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(value = { NoResourceFoundException.class })
    public ResponseEntity<ErrorMessage> noResourceFoundException(NoResourceFoundException e) {
        log.error(e.getMessage(), e.getCause());
        ErrorMessage errorMessage = new ErrorMessage(LocalDateTime.now(), HttpStatus.NOT_FOUND.value(), e.getMessage());
        return new ResponseEntity<>(errorMessage, HttpStatus.NOT_FOUND);
    }
}
