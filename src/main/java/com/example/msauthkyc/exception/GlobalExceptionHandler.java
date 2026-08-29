package com.example.msauthkyc.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(MissingRefreshTokenException.class)
    public ResponseEntity<Void> handleMissingToken(MissingRefreshTokenException e) {
        log.warn("Refresh token göndərilməyib: {}", e.getMessage());
        return ResponseEntity.badRequest().build();
    }

    @ExceptionHandler(InvalidRefreshTokenException.class)
    public ResponseEntity<Void> handleInvalidToken(InvalidRefreshTokenException e) {
        log.warn("Etibarsız refresh token: {}", e.getMessage());
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
    }
}