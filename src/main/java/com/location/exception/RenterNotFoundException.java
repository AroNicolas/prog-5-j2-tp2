package com.location.exception;

public class RenterNotFoundException extends RuntimeException {
    public RenterNotFoundException(String message) {
        super(message);
    }
}
