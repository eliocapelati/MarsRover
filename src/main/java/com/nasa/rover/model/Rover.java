package com.nasa.rover.model;

import java.util.List;

import org.apache.solr.client.solrj.beans.Field;
import org.springframework.data.annotation.Id;
import org.springframework.data.geo.Point;
import org.springframework.data.solr.core.mapping.SolrDocument;

import com.nasa.rover.action.Direction;
/**
 * 
 * @author eliocapelati
 *
 */
@SolrDocument(solrCoreName = "gettingstarted")
public class Rover {
	
	@Id @Field
	private String id;
	@Field
	private Point plateauBorder;
	@Field
	private Point startPoint;
	@Field
	private Point endPoint;
	@Field
	private String startDirection;
	@Field
	private String endDirection;
	@Field(child=true)
	private List<String> movements;
	private Boolean moved;
	
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

	public Point getStartPoint() {
		return startPoint;
	}
	public void setStartPoint(Point point) {
		this.startPoint = point;
	}
	public String getStartDirection() {
		return startDirection;
	}
	public void setStartDirection(Direction direction) {
		this.startDirection = direction.getDirection();
	}
	public void setStartDirection(String direction) {
		this.startDirection = direction;
	}
	public List<String> getMovements() {
		return movements;
	}
	public void setMovements(List<String> movements) {
		this.movements = movements;
	}
	
	

	/**
	 * @return the endPoint
	 */
	public Point getEndPoint() {
		return endPoint;
	}

	/**
	 * @param endPoint the endPoint to set
	 */
	public void setEndPoint(Point endPoint) {
		this.endPoint = endPoint;
	}

	/**
	 * @return the endDirection
	 */
	public String getEndDirection() {
		return endDirection;
	}

	/**
	 * @param endDirection the endDirection to set
	 */
	public void setEndDirection(String endDirection) {
		this.endDirection = endDirection;
	}

	/**
	 * @return the moved
	 */
	public Boolean getMoved() {
		return moved;
	}

	/**
	 * @param moved the moved to set
	 */
	public void setMoved(Boolean moved) {
		this.moved = moved;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((endDirection == null) ? 0 : endDirection.hashCode());
		result = prime * result + ((endPoint == null) ? 0 : endPoint.hashCode());
		result = prime * result + ((movements == null) ? 0 : movements.hashCode());
		result = prime * result + ((plateauBorder == null) ? 0 : plateauBorder.hashCode());
		result = prime * result + ((startDirection == null) ? 0 : startDirection.hashCode());
		result = prime * result + ((startPoint == null) ? 0 : startPoint.hashCode());
		return result;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (!(obj instanceof Rover)) {
			return false;
		}
		Rover other = (Rover) obj;
		if (endDirection == null) {
			if (other.endDirection != null) {
				return false;
			}
		} else if (!endDirection.equals(other.endDirection)) {
			return false;
		}
		if (endPoint == null) {
			if (other.endPoint != null) {
				return false;
			}
		} else if (!endPoint.equals(other.endPoint)) {
			return false;
		}
		if (movements == null) {
			if (other.movements != null) {
				return false;
			}
		} else if (!movements.equals(other.movements)) {
			return false;
		}
		if (plateauBorder == null) {
			if (other.plateauBorder != null) {
				return false;
			}
		} else if (!plateauBorder.equals(other.plateauBorder)) {
			return false;
		}
		if (startDirection == null) {
			if (other.startDirection != null) {
				return false;
			}
		} else if (!startDirection.equals(other.startDirection)) {
			return false;
		}
		if (startPoint == null) {
			if (other.startPoint != null) {
				return false;
			}
		} else if (!startPoint.equals(other.startPoint)) {
			return false;
		}
		return true;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Rover [");
		if (id != null) {
			builder.append("id=");
			builder.append(id);
			builder.append(", ");
		}
		if (plateauBorder != null) {
			builder.append("plateauBorder=");
			builder.append(plateauBorder);
			builder.append(", ");
		}
		if (startPoint != null) {
			builder.append("startPoint=");
			builder.append(startPoint);
			builder.append(", ");
		}
		if (endPoint != null) {
			builder.append("endPoint=");
			builder.append(endPoint);
			builder.append(", ");
		}
		if (startDirection != null) {
			builder.append("startDirection=");
			builder.append(startDirection);
			builder.append(", ");
		}
		if (endDirection != null) {
			builder.append("endDirection=");
			builder.append(endDirection);
			builder.append(", ");
		}
		if (movements != null) {
			builder.append("movements=");
			builder.append(movements);
			builder.append(", ");
		}
		if (moved != null) {
			builder.append("moved=");
			builder.append(moved);
		}
		builder.append("]");
		return builder.toString();
	}
	

}
