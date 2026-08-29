package com.example.msauthkyc.exception;

public class InvalidRefreshTokenException extends RuntimeException {
    public InvalidRefreshTokenException(String message, Throwable cause) {
        super(message, cause);
    }
}
