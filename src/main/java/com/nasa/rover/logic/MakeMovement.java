package com.nasa.rover.logic;

import java.util.Objects;

import org.springframework.data.geo.Box;
import org.springframework.data.geo.Point;

import com.nasa.rover.action.Direction;
import com.nasa.rover.action.Movement;
import com.nasa.rover.model.Rover;

/**
 * 
 * @author eliocapelati
 *
 */
public class MakeMovement {
    private static final Point FIXED_BASE_POSITION = new Point(0, 0);

    public Rover move(Rover in) throws OutOfBoundaryException {
        Objects.requireNonNull(in);
        Box box = new Box(FIXED_BASE_POSITION, in.getPlateauBorder());

        if (in.getMovements().isEmpty()) {
            in.setEndPoint(in.getStartPoint());
            in.setEndDirection(in.getStartDirection());
            in.setMoved(Boolean.TRUE);
            return in;
        }

        if (isInBoundaries(box, in.getStartPoint())) {
            for (String mov : in.getMovements()) {
                Movement parse = Movement.parse(mov);
                switch (parse) {
                case MOVE:
                    makeMovement(in, box);
                    break;
                case TURN_LEFT:
                case TURN_RIGHT:
                    changeDirection(in, parse);
                    break;
                default:
                    break;
                }
            }
        } else {
            throw new OutOfBoundaryException("The Rover cant be moved");
        }

        return in;
    }

    private void makeMovement(Rover in, Box box) throws OutOfBoundaryException {
        Direction direction;
        Point point;
        if (in.getEndDirection() == null) {
            direction = Direction.parse(in.getStartDirection());
        } else {
            direction = Direction.parse(in.getEndDirection());
        }
        if (in.getEndPoint() == null) {
            point = in.getStartPoint();
        } else {
            point = in.getEndPoint();
        }
        if (isInBoundaries(box, direction.move(point))) {
            in.setEndPoint(direction.move(in.getStartPoint()));
            in.setMoved(Boolean.TRUE);
        } else {
            throw new OutOfBoundaryException(
                    String.format("The Rover cant be moved [from %s], [to %s] ", point, direction.move(point)));
        }
    }

    private void changeDirection(Rover in, Movement parse) {
        if (in.getEndDirection() == null) {
            in.setEndDirection(parse.changeDirection(Direction.parse(in.getStartDirection())).getDirection());
        } else {
            in.setEndDirection(parse.changeDirection(Direction.parse(in.getEndDirection())).getDirection());
        }
    }

    private static Boolean isInBoundaries(Box box, Point roverPosition) {
        Point first = box.getFirst();
        Point second = box.getSecond();

        return (roverPosition.getX() >= first.getX() && roverPosition.getX() <= second.getX())
                && (roverPosition.getY() <= second.getY() && roverPosition.getY() >= first.getY());
    }
}
