package com.nasa.rover.action;

import static org.junit.Assert.*;

import org.junit.Test;

public class DirectionTest {

	@Test
	public void testParse() {
		assertEquals(Direction.WEST, Direction.parse("W"));
		assertEquals(Direction.NORTH, Direction.parse("N"));
		assertEquals(Direction.EAST, Direction.parse("E"));
		assertEquals(Direction.SOUTH, Direction.parse("S"));
		assertEquals(Direction.NONE, Direction.parse(""));
		assertEquals(Direction.NONE, Direction.parse("Z"));
		
	}

}
