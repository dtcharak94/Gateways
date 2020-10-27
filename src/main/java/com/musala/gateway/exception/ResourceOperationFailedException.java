package com.musala.gateway.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;


@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
public class ResourceOperationFailedException extends RuntimeException {

    public ResourceOperationFailedException() {
        super();
    }

    public ResourceOperationFailedException(String message) {
        super(message);
    }

    public ResourceOperationFailedException(String message, Throwable cause) {
        super(message, cause);
    }
}
