package com.GlobeTrotter.Exception;

public class GlobeTrotterException extends RuntimeException {
    public GlobeTrotterException(String message) {
        super(message);
    }

    public GlobeTrotterException(String message, Throwable cause) {
        super(message, cause);
    }
}
