package com.petcareconnect.api.exception;

public class NoResourceFoundException extends RuntimeException{
    public NoResourceFoundException(String message) {
        super(message);
    }
}
