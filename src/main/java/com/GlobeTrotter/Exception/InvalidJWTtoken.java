package com.GlobeTrotter.Exception;

public class InvalidJWTtoken extends RuntimeException{
    public InvalidJWTtoken(String message) {
        super(message);
    }
}
