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
	TURN_LEFT("L") {
		@Override
		public Direction changeDirection(Direction dir) {
			return Direction.values()[(dir.ordinal() + 3) % 4];
		}
	}, 
	/**
	 * Turn RIGHT command
	 * <code>R</code>
	 */
	TURN_RIGHT("R") {
		@Override
		public Direction changeDirection(Direction dir) {
		        return Direction.values()[(dir.ordinal() + 1) % 4];
		}
	}, 
	/**
	 * MOVE command
	 * <code>M</code>
	 */
	MOVE("M") {
		@Override
		public Direction changeDirection(Direction dir) {
			return dir;
		}
	},
	/**
	 * Turn LEFT command
	 * <code>EMPTY</code>
	 */
	STAY("") {
		@Override
		public Direction changeDirection(Direction dir) {
			return dir;
		}
	};
	
	private String command;
	
	private Movement(String command){
		this.command = command;		
	}
	
	/**
	 * Change direction based on {@code TURN_LEFT} and {@code TURN_RIGT}
	 * @param dir
	 * @return
	 */
	public abstract Direction changeDirection(Direction dir);
	
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
