package com.nasa.rover.logic;

import static org.junit.Assert.assertEquals;

import java.util.Iterator;
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
				+ "LMLMLMLMM\n"
				+ "3 3 E\n"
				+ "MMRMMRMRRM";
		
		rover = InputParser.builder().withInput(test).build().parse();
	}
	
	@Test
	public void testMove() throws OutOfBoundaryException {
		MakeMovement calculateMovement = new MakeMovement();
		
		Iterator<Rover> iterator = rover.iterator();
		
		Rover move1 = calculateMovement.move(iterator.next());
		assertEquals(new Point(1,3), move1.getEndPoint());
		assertEquals("N", move1.getEndDirection());
		
		MakeMovement calculateMovement2 = new MakeMovement();
		
		Rover move2 = calculateMovement2.move(iterator.next());
		assertEquals(new Point(5,1), move2.getEndPoint());
        assertEquals("E", move2.getEndDirection());
		
		
	}
	

}
