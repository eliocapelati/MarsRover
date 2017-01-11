package com.nasa.rover.action;

import java.util.stream.Stream;

/**
 * 
 * @author eliocapelati
 *
 */
public enum Movement {
	
	/**
	 * Turn LEFT command
	 * <code>L</code>
	 */
	TURN_LEFT("L"), 
	/**
	 * Turn RIGHT command
	 * <code>R</code>
	 */
	TURN_RIGHT("R"), 
	/**
	 * MOVE command
	 * <code>M</code>
	 */
	MOVE("M"),
	/**
	 * Turn LEFT command
	 * <code>EMPTY</code>
	 */
	STAY("");
	
	private String command;
	
	private Movement(String command){
		this.command = command;		
	}
	
	/**
	 * 
	 * @return
	 */
	public String getCommand(){
		return command;
	}
	
	/**
	 * Get a movement based on a SINGLE character command.
	 * @param command
	 * @return
	 */
	public static Movement parse(String command){
		return Stream.of(Movement.values()).
				filter(m -> m.command.equalsIgnoreCase(command)).
				findFirst().
				orElse(Movement.STAY);
	}
	
}
