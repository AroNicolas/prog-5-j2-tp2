package com.location.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class ObjectUnavailableException extends RuntimeException {
    public ObjectUnavailableException(String msg) {
        super(msg);
    }
}
