package com.nasa.rover.model;

import static org.junit.Assert.assertNotNull;

import java.util.Arrays;

import org.junit.Test;
import org.springframework.data.geo.Point;

import com.nasa.rover.action.Direction;
import com.nasa.rover.action.Movement;

/**
 * 
 * @author eliocapelati
 *
 */
public class RoverTest {
	
	@Test
	public void test(){
		Rover r = new Rover();
		r.setStartDirection(Direction.EAST);
		r.setMovements(Arrays.asList(Movement.MOVE.getCommand(), Movement.TURN_LEFT.getCommand(), Movement.TURN_RIGHT.getCommand()));
		r.setStartPoint(new Point(1, 3));
		assertNotNull(r);
	}
	

}
