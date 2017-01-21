package com.nasa.rover.parser;

import java.util.regex.Pattern;
import java.util.stream.Stream;

/**
 * 
 * @author eliocapelati
 *
 */
public enum Patterns {
	PLATEAU {
		@Override
		public Pattern getPattern() {
			return Pattern.compile("((\\d)\\s?){1,}(\\n|\\r\\n|\\r)?");
		}
	},
	ROBOT {
		@Override
		public Pattern getPattern() {
			return Pattern.compile("(\\d+\\s+){2}[NEWS]{1}(\\n|\\r\\n|\\r)?");
		}
	},
	MOVEMENTS {
		@Override
		public Pattern getPattern() {
			return Pattern.compile("[LMR]+(\\n|\\r\\n|\\r)?");
		}
	},
	NONE{
		@Override
		public Pattern getPattern() {
			return Pattern.compile("");
		}
	};
	
	/**
	 * 
	 * @return {@link Pattern} to extract based on string
	 */
	public abstract Pattern getPattern(); 
	
	/**
	 * 
	 * @param line to define pattern to be used
	 * @return 
	 */
	public static Patterns parse(String line){
		return Stream.of(Patterns.values()).
				filter(p -> p.getPattern().matcher(line).matches()).
				findFirst().
				orElse(Patterns.NONE);
	} 
	
	/**
	 * 
	 * @param line
	 * @param other
	 * @return
	 */
	public static Boolean isEquals(String line, Patterns other){
		return Patterns.parse(line).equals(other);
	}
}
