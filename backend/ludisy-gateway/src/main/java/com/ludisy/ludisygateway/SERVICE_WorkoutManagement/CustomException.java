package com.ludisy.ludisygateway.SERVICE_WorkoutManagement;

/**
 * Temporary exception class
 */
public class CustomException extends RuntimeException {

    public CustomException(String message) {
        super(message);
    }

    public CustomException(String message, Throwable cause) {
        super(message, cause);
    }
}
