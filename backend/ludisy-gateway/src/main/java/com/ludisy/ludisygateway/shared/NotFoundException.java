package com.ludisy.ludisygateway.shared;

/**
 * Custom exception for 404 NOT_FOUND status
 */
public class NotFoundException extends RuntimeException{

    public NotFoundException(String message) {
        super(message);
    }
}
