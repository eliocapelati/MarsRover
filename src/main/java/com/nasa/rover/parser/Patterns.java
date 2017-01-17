package com.nasa.rover.parser;

import java.util.regex.Pattern;

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
	DIRECTION {
		@Override
		public Pattern getPattern() {
			return Pattern.compile("[LMR]+(\\n|\\r\\n|\\r)?");
		}
	};
	
	public abstract Pattern getPattern(); 
}
