package com.nasa.rover.service;

/**
 * 
 * @author eliocapelati
 *
 */
public class RoverServiceException extends Exception {

    /**
     * 
     */
    private static final long serialVersionUID = 2943858864934800619L;

    public RoverServiceException() {
    }

    public RoverServiceException(String message) {
        super(message);
    }

    public RoverServiceException(Throwable cause) {
        super(cause);
    }

    public RoverServiceException(String message, Throwable cause) {
        super(message, cause);
    }

    public RoverServiceException(String message, Throwable cause, boolean enableSuppression,
            boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

}
