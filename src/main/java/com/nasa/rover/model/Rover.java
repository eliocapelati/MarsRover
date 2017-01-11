package com.nasa.rover.model;

import java.util.List;

import org.springframework.data.annotation.Id;

import com.nasa.rover.action.Direction;
import com.nasa.rover.action.Movement;
import org.springframework.data.geo.Point;
/**
 * 
 * @author eliocapelati
 *
 */
public class Rover {
	
	@Id
	private String id;
	private Point point;
	private Direction direction;
	private List<Movement> movements;
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	
	public Point getPoint() {
		return point;
	}
	public void setPoint(Point point) {
		this.point = point;
	}
	public Direction getDirection() {
		return direction;
	}
	public void setDirection(Direction direction) {
		this.direction = direction;
	}
	public List<Movement> getMovements() {
		return movements;
	}
	public void setMovements(List<Movement> movements) {
		this.movements = movements;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((direction == null) ? 0 : direction.hashCode());
		result = prime * result + ((movements == null) ? 0 : movements.hashCode());
		result = prime * result + ((point == null) ? 0 : point.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Rover other = (Rover) obj;
		if (direction != other.direction)
			return false;
		if (movements == null) {
			if (other.movements != null)
				return false;
		} else if (!movements.equals(other.movements))
			return false;
		if (point == null) {
			if (other.point != null)
				return false;
		} else if (!point.equals(other.point))
			return false;
		return true;
	}
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Rover [");
		if (point != null) {
			builder.append("point=");
			builder.append(point);
			builder.append(", ");
		}
		if (direction != null) {
			builder.append("direction=");
			builder.append(direction);
			builder.append(", ");
		}
		if (movements != null) {
			builder.append("movements=");
			builder.append(movements);
		}
		builder.append("]");
		return builder.toString();
	}
	
}
