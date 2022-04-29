package com.asapp.backend.challenge.application.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class ContentTypeNotAvailableException extends RuntimeException {

    public ContentTypeNotAvailableException(String message) {
        super(message);
    }
}
