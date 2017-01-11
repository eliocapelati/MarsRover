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

}
