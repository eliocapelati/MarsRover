package com.nasa.rover.logic;

/**
 * 
 * @author eliocapelati
 *
 */
public class OutOfBoundaryException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6692508563112260130L;

	public OutOfBoundaryException() {
	}

	public OutOfBoundaryException(String message) {
		super(message);
	}

	public OutOfBoundaryException(Throwable cause) {
		super(cause);
	}

	public OutOfBoundaryException(String message, Throwable cause) {
		super(message, cause);
	}

	public OutOfBoundaryException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

}
