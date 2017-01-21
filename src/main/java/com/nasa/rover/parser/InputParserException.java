package com.nasa.rover.parser;

/**
 * 
 * @author eliocapelati
 *
 */
public class InputParserException extends Exception {


	/**
	 * 
	 */
	private static final long serialVersionUID = -2139821063550698922L;

	/**
	 * 
	 */
	public InputParserException() {
		super();
	}

	/**
	 * @param message
	 * @param cause
	 * @param enableSuppression
	 * @param writableStackTrace
	 */
	public InputParserException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	/**
	 * @param message
	 * @param cause
	 */
	public InputParserException(String message, Throwable cause) {
		super(message, cause);
	}

	/**
	 * @param message
	 */
	public InputParserException(String message) {
		super(message);
	}

	/**
	 * @param cause
	 */
	public InputParserException(Throwable cause) {
		super(cause);
	}

}
