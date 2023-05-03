package com.atmosferpoc.core.exception;

public final class AlreadyExistException extends RuntimeException{
    public AlreadyExistException() {
        super();
    }

    public AlreadyExistException(String message) {
        super(message);
    }

    public AlreadyExistException(String message, Throwable throwable) {
        super(message, throwable);
    }
}
