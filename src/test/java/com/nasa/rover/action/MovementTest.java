package com.nasa.rover.action;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * 
 * @author eliocapelati
 *
 */
public class MovementTest {

	@Test
	public void testParse() {
		assertEquals(Movement.MOVE , Movement.parse("M"));
		assertEquals(Movement.TURN_LEFT , Movement.parse("L"));
		assertEquals(Movement.TURN_RIGHT , Movement.parse("R"));
		assertEquals(Movement.STAY , Movement.parse("Z"));
		assertEquals(Movement.STAY , Movement.parse(""));
	}
	
	@Test
	public void testeChangeDirection(){
		
		assertEquals(Direction.EAST, Movement.TURN_LEFT.changeDirection(Direction.SOUTH));
		assertEquals(Direction.EAST, Movement.TURN_RIGHT.changeDirection(Direction.NORTH));
		
		assertEquals(Direction.SOUTH, Movement.TURN_LEFT.changeDirection(Direction.WEST));
		assertEquals(Direction.SOUTH, Movement.TURN_RIGHT.changeDirection(Direction.EAST));
		
		assertEquals(Direction.WEST, Movement.TURN_LEFT.changeDirection(Direction.NORTH));
		assertEquals(Direction.WEST, Movement.TURN_RIGHT.changeDirection(Direction.SOUTH));
		
		assertEquals(Direction.NORTH, Movement.TURN_LEFT.changeDirection(Direction.EAST));
		assertEquals(Direction.NORTH, Movement.TURN_RIGHT.changeDirection(Direction.WEST));
		
		assertEquals(Direction.NORTH, Movement.MOVE.changeDirection(Direction.NORTH));
		assertEquals(Direction.NORTH, Movement.STAY.changeDirection(Direction.NORTH));
		
	}

}
