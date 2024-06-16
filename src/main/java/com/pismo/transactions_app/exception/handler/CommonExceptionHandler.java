package com.pismo.transactions_app.exception.handler;

import com.pismo.transactions_app.dto.ExceptionResponse;
import com.pismo.transactions_app.exception.ResourceNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class CommonExceptionHandler {
    @ExceptionHandler({ResourceNotFoundException.class})
    public ResponseEntity<ExceptionResponse> resourceNotFoundExceptionHandler(ResourceNotFoundException ex) {
        return ResponseEntity.ok(new ExceptionResponse("NOT_FOUND", ex.getMessage()));
    }
}
