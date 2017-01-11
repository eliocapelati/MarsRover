package com.nasa.rover.action;

import java.util.stream.Stream;

/**
 * 
 * @author eliocapelati
 *
 */
public enum Direction {
	
	NORTH("N"),
	WEST("W"),
	EAST("E"),
	SOUTH("S"),
	NONE("");
	
	private String direction;
		
	private Direction(final String direction) {
		this.direction = direction;
	}
	
	public String getDirection(){
		return direction;
	}
	
	/**
	 * Parse direction based on a single character.
	 * @param command
	 * @return
	 */
	public static Direction parse(String direction){
		return Stream.of(Direction.values()).
				filter(m -> m.direction.equalsIgnoreCase(direction)).
				findFirst().
				orElse(Direction.NONE);
	}
}
