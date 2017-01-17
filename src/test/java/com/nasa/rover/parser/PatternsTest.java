package com.nasa.rover.parser;

import static org.junit.Assert.*;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.junit.Test;

public class PatternsTest {
	
	
	@Test
	public void testPlateau() {
		String input = "5 5\n";
		String input2 = "5 5 \n";
		String input3 = "5 5";
		Pattern pattern = Patterns.PLATEAU.getPattern();
		Matcher matcher = pattern.matcher(input);
		Matcher matcher2 = pattern.matcher(input2);
		Matcher matcher3 = pattern.matcher(input3);
		
		assertTrue(matcher.matches());
		assertTrue(matcher2.matches());
		assertTrue(matcher3.matches());
		
	}
	
	@Test
	public void testPlateauFail() {
		String sample1 = "5 G";
		String sample2 = "B B";
		String sample3 = "ASDF";
		Pattern pattern = Patterns.PLATEAU.getPattern();
		
		Matcher matcher = pattern.matcher(sample1);
		Matcher matcher2 = pattern.matcher(sample2);
		Matcher matcher3 = pattern.matcher(sample3);
		
		assertFalse(matcher.matches());
		assertFalse(matcher2.matches());
		assertFalse(matcher3.matches());
		
	}
	
	@Test
	public void testRobots() {
		String sample1 = "1 2 N\n";
		String sample2 = "3 3 E\n";
		String sample3 = "3 3 E";
		Pattern pattern = Patterns.ROBOT.getPattern();
		Matcher matcher = pattern.matcher(sample1);
		Matcher matcher2 = pattern.matcher(sample2);
		Matcher matcher3 = pattern.matcher(sample3);
		
		assertTrue(matcher.matches());
		assertTrue(matcher2.matches());
		assertTrue(matcher3.matches());
		
	}
	
	
	@Test
	public void testRobotsFail() {
		String sample1 = "1 2 3";
		String sample2 = "V A";
		String sample3 = "I F 1";
		Pattern pattern = Patterns.ROBOT.getPattern();
		
		Matcher matcher = pattern.matcher(sample1);
		Matcher matcher2 = pattern.matcher(sample2);
		Matcher matcher3 = pattern.matcher(sample3);
		
		assertFalse(matcher.matches());
		assertFalse(matcher2.matches());
		assertFalse(matcher3.matches());
		
	}
	
	@Test
	public void testDirections() {
		String sample1 = "LMRLMLMMM\n";
		String sample2 = "LMLMLMMM\n";
		String sample3 = "LRMMMLM";
		Pattern pattern = Patterns.DIRECTION.getPattern();
		Matcher matcher = pattern.matcher(sample1);
		Matcher matcher2 = pattern.matcher(sample2);
		Matcher matcher3 = pattern.matcher(sample3);
		
		assertTrue(matcher.matches());
		assertTrue(matcher2.matches());
		assertTrue(matcher3.matches());
		
	}
	
	
	@Test
	public void testDirectionsFail() {
		String sample1 = "L M R";
		String sample2 = "";
		String sample3 = "L M MMM";
		Pattern pattern = Patterns.DIRECTION.getPattern();
		
		Matcher matcher = pattern.matcher(sample1);
		Matcher matcher2 = pattern.matcher(sample2);
		Matcher matcher3 = pattern.matcher(sample3);
		
		assertFalse(matcher.matches());
		assertFalse(matcher2.matches());
		assertFalse(matcher3.matches());
		
	}

}
