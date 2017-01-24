package com.nasa.rover.logic;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.springframework.data.geo.Point;

import com.nasa.rover.model.Rover;
import com.nasa.rover.parser.InputParser;
import com.nasa.rover.parser.InputParserException;

/**
 * 
 * @author eliocapelati
 *
 */
public class MakeMovementTest {

	private List<Rover> rover;
	
	@Before
	public void setup() throws InputParserException{
		String test = "5 5\n"
				+ "1 2 N\n"
				+ "LMLMLMLMM";
		rover = InputParser.builder().withInput(test).build().parse();
	}
	
	@Test
	public void testMove() throws OutOfBoundaryException {
		MakeMovement calculateMovement = new MakeMovement();
		Rover move = calculateMovement.move(rover.get(0));
		assertEquals(new Point(1,3), move.getEndPoint());
		assertEquals("N", move.getEndDirection());
	}

}
