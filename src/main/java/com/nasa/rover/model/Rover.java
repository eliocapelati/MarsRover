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
	private Point plateauBorder;
	private Point point;
	private Direction direction;
	private List<Movement> movements;
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	
	public Point getPlateauBorder() {
		return plateauBorder;
	}

	public void setPlateauBorder(Point plateauBorder) {
		this.plateauBorder = plateauBorder;
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
	
	
	
}
