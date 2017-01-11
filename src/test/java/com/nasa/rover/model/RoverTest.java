package com.nasa.rover.model;

import java.util.Arrays;

import org.junit.Test;
import static org.junit.Assert.*;

import com.nasa.rover.action.Direction;
import com.nasa.rover.action.Movement;
import org.springframework.data.geo.Point;

/**
 * 
 * @author eliocapelati
 *
 */
public class RoverTest {
	
	@Test
	public void test(){
		Rover r = new Rover();
		r.setDirection(Direction.EAST);
		r.setMovements(Arrays.asList(Movement.MOVE, Movement.TURN_LEFT, Movement.TURN_RIGHT));
		r.setPoint(new Point(1, 3));
		assertNotNull(r);
	}
	

}
