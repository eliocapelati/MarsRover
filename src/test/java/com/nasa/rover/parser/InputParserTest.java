package com.nasa.rover.parser;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.nasa.rover.parser.InputParser.ParserBuilder;

/**
 * 
 * @author eliocapelati
 *
 */
public class InputParserTest {
	
	private static final String input = "5 5\n"
			+ "1 2 N\n"
			+ "LMLMLMLMM\n"
			+ "3 3 E\n"
			+ "MMRMMRMRRM";

	@Test
	public void testVerifyIncomeOfInput() {
		ParserBuilder builder = new ParserBuilder();
		InputParser parser = builder.withInput("5 5\n"
				+ "1 2 N\n"
				+ "LMLMLMLMM\n"
				+ "3 3 E\n"
				+ "MMRMMRMRRM").build();
		assertNotNull(parser.getInput());
	}
	
	@Test
	public void testValidSize(){
		InputParser parser = new ParserBuilder().withInput(input).build();
		assertTrue(parser.isValidSize());
	}
	@Test
	public void testInValidSize(){
		InputParser parser = new ParserBuilder().withInput("").build();
		InputParser parserWithNullString = new ParserBuilder().withInput(null).build();
		assertFalse(parser.isValidSize());
		assertFalse(parserWithNullString.isValidSize());
	}
	
	

}
