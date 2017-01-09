package com.nasa.rover.action;

import static org.junit.Assert.*;

import org.junit.Test;

public class MovementTest {

	@Test
	public void testGetMovement() {
		assertEquals(Movement.MOVE , Movement.getMovement("M"));
		assertEquals(Movement.TURN_LEFT , Movement.getMovement("L"));
		assertEquals(Movement.TURN_RIGHT , Movement.getMovement("R"));
		assertEquals(Movement.STAY , Movement.getMovement("Z"));
		assertEquals(Movement.STAY , Movement.getMovement(""));
	}

}
