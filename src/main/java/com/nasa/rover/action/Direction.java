package com.nasa.rover.action;

import java.util.stream.Stream;

import org.springframework.data.geo.Point;

/**
 * 
 * @author eliocapelati
 *
 */
public enum Direction {

	NORTH("N") {
		@Override
		public Point move(Point point) {
			return new Point(point.getX(), point.getY() + 1);
		}
	},
	EAST("E") {
		@Override
		public Point move(Point point) {
			return new Point(point.getX() + 1, point.getY());
		}
	},
	SOUTH("S") {
		@Override
		public Point move(Point point) {
			return new Point(point.getX(), point.getY() - 1);
		}
	},
	WEST("W") {
		@Override
		public Point move(Point point) {
			return new Point(point.getX() - 1, point.getY());
		}
	};

	private String direction;

	private Direction(final String direction) {
		this.direction = direction;
	}

	public String getDirection() {
		return direction;
	}

	/**
	 * Parse direction based on a single character.
	 * 
	 * @param command
	 * @return
	 */
	public static Direction parse(String direction) {
		return Stream.of(Direction.values()).filter(m -> m.direction.equalsIgnoreCase(direction)).findFirst()
				.orElse(Direction.NORTH);
	}
	/**
	 * Make a step movement based on direction
	 * @param point Point to movement
	 * @return new Point on final position
	 */
	public abstract Point move(Point point);
}
