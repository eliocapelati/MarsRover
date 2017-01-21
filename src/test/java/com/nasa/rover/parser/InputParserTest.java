package com.nasa.rover.parser;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Test;

import com.nasa.rover.model.Rover;
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
	
	@Test(expected=InputParserException.class)
	public void testInvalidParserExceptionOnInvaldPlateau() throws InputParserException{
		String test = "5 A\n"
					+ "1 2 N\n"
					+ "LMLMLMLMM\n";
		new ParserBuilder().withInput(test).build().parse();
	}
	
	@Test(expected=InputParserException.class)
	public void testInvalidParserExceptionOnInvaldSize() throws InputParserException{
		String test = "5 A\n"
					+ "1 2 N\n";
		InputParser.builder().withInput(test).build().parse();
	}
	
	@Test
	public void testValidParser() throws InputParserException{
		String test = "5 5\n"
					+ "1 2 N\n"
					+ "MMRMMRMRRM";
		List<Rover> parse = InputParser.builder().withInput(test).build().parse();
		System.out.println(parse);
	}
	
	

}
