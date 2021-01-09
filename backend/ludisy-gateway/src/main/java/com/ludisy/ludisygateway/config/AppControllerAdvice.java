package com.ludisy.ludisygateway.config;

import com.ludisy.ludisygateway.shared.NotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * Managing error handling globally
 */
@ControllerAdvice
public class AppControllerAdvice {

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<Object> handleNotFound (NotFoundException e) {
        return new ResponseEntity<>((HttpStatus.NOT_FOUND));

    }

}
