package com.nasa.rover.parser;

/**
 * 
 * @author eliocapelati
 *
 */
public class InputParser {
	
	private String input;
	
	private InputParser() {
	}
	
	public String getInput(){
		return input;
	}
	
	private void setInput(String input){
		this.input = input;
	}
	
	/**
	 * 
	 * @return True if has a valid size of provided input
	 */
	public Boolean isValidSize(){
		if(input == null){
			return Boolean.FALSE;
		}
		int size = input.split("\r|\r\n|\n").length;
		if(size <= 1 || size % 2 == 0){
			return Boolean.FALSE;
		} 
		return Boolean.TRUE;
	}
	
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
	

}
