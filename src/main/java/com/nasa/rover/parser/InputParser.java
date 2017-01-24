package com.nasa.rover.parser;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.data.geo.Point;

import com.nasa.rover.action.Direction;
import com.nasa.rover.model.Rover;

/**
 * 
 * @author eliocapelati
 *
 */
public class InputParser {
	
	private static final String LINE_BREAKER = "\r|\r\n|\n";
	private static final String SPACE_REGEX = " ";
	private static final String SPLIT_REGEX = "";
	private String input;
	
	
	private InputParser() {
	}
	
	public String getInput(){
		return input;
	}
	
	private void setInput(String input){
		this.input = input;
	}
	
	
	public List<Rover> parse() throws InputParserException{
		List<Rover> list = new ArrayList<>();
		Point plateauBorder;

		if(isValidSize()) {
			Iterator<String> lines = Arrays.asList(input.split(LINE_BREAKER)).iterator();
			plateauBorder = extractPlateauBorder(lines.next());
			while(lines.hasNext()){
				list.add(extractRover(lines.next(), lines.next(), plateauBorder));
			}
		}else{
			throw new InputParserException(String.format("The input provided does not contain a valid size [input] :%s ", input));
		}
		return list;
	}

	private Point extractPlateauBorder(String raw) throws InputParserException{
		if(Patterns.isEquals(raw, Patterns.PLATEAU)){
			String[] values = raw.split(SPACE_REGEX);
			return new Point(Long.valueOf(values[0]), Long.valueOf(values[1]));
		}else{
			throw new InputParserException(String.format("Invalid Plateau Border: %s", raw));
		}
		
	}
	
	private Rover extractRover(String positionAndDirection, 
			String movements, 
			Point plateauBorder) throws InputParserException{
		
		Rover rover = new Rover();
		rover.setPlateauBorder(plateauBorder);
		extractRoverPositionAndDirection(positionAndDirection, rover);
		rover.setMovements(extractMovements(movements));
		
		return rover;
	}

	private List<String> extractMovements(String movements) throws InputParserException {
		if(Patterns.isEquals(movements, Patterns.MOVEMENTS)){
			return Stream.of(movements.split(SPLIT_REGEX)).
					collect(Collectors.toList());
		} else {
			throw new InputParserException(String.format("Invalid Movements: %s", movements));
		}
	}

	private void extractRoverPositionAndDirection(String positionAndDirection, Rover rover) throws InputParserException {
		
		if(Patterns.isEquals(positionAndDirection, Patterns.ROBOT)){
			String[] values = positionAndDirection.split(SPACE_REGEX);
			rover.setStartPoint(new Point(Long.valueOf(values[0]), Long.valueOf(values[1])));
			rover.setStartDirection(Direction.parse(values[2]));
		}else{
			throw new InputParserException(String.format("Invalid Rover Position: %s", positionAndDirection));
		}
	}
	
	/**
	 * 
	 * @return True if has a valid size of provided input
	 */
	public Boolean isValidSize(){
		if(input == null){
			return Boolean.FALSE;
		}
		int size = input.split(LINE_BREAKER).length;
		if(size <= 1 || size % 2 == 0){
			return Boolean.FALSE;
		} 
		return Boolean.TRUE;
	}
	
	
	
	/**
	 * 
	 * @author eliocapelati
	 *
	 */
	public static class ParserBuilder {
		private InputParser parser;
		
		public ParserBuilder() {
			parser = new InputParser();
		}
		
		public ParserBuilder withInput(String input) {
			parser.setInput(input);
			return this;
		}
		public InputParser build() {
			return parser;
		}
	}
	
	public static ParserBuilder builder(){
		return new ParserBuilder();
	}

}
