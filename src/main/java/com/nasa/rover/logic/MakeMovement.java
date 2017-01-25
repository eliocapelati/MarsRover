package com.nasa.rover.logic;

import java.util.Objects;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
    private static final Logger log = LoggerFactory.getLogger(MakeMovement.class);
    private static final Point FIXED_BASE_POSITION = new Point(0, 0);
    
    public Rover move(Rover in) throws OutOfBoundaryException {
        Objects.requireNonNull(in);
        log.trace("Rover received to movement: {}", in);
        
        Box box = new Box(FIXED_BASE_POSITION, in.getPlateauBorder());

        if (in.getMovements().isEmpty()) {
            in.setEndPoint(in.getStartPoint());
            in.setEndDirection(in.getStartDirection());
            in.setMoved(Boolean.TRUE);
            log.debug("The rover has no movement: {}", in);
            return in;
        }

        if (isInBoundaries(box, in.getStartPoint())) {
            for (String mov : in.getMovements()) {
                Movement parse = Movement.parse(mov);
                log.debug("Moving rover to: {}", parse);
                switch (parse) {
                case TURN_LEFT:
                case TURN_RIGHT:
                    changeDirection(in, parse);
                    break;
                case MOVE:
                    makeMovement(in, box);
                    break;
                default:
                    break;
                }
            }
        } else {
            log.error("The Rover cant be moved: {}", in);
            throw new OutOfBoundaryException("The Rover cant be moved");
        }

        return in;
    }

    private void makeMovement(Rover in, Box box) throws OutOfBoundaryException {
        Direction direction;
        Point point;
        if (in.getEndDirection() == null || in.getEndDirection().isEmpty()) {
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
            in.setEndPoint(direction.move(point));
            in.setMoved(Boolean.TRUE);
        } else {
            log.error("The Rover cant be moved [from {}], [to {}]", point, direction.move(point));
            throw new OutOfBoundaryException(
                    String.format("The Rover cant be moved [from %s], [to %s] ", point, direction.move(point)));
        }
        log.debug("The rover has been moved: {}", in);
    }

    private void changeDirection(Rover in, Movement parse) {
        if (in.getEndDirection() == null || in.getEndDirection().isEmpty()) {
            in.setEndDirection(parse.changeDirection(Direction.parse(in.getStartDirection())).getDirection());
        } else {
            in.setEndDirection(parse.changeDirection(Direction.parse(in.getEndDirection())).getDirection());
        }
        in.setMoved(Boolean.TRUE);
        log.debug("The rover has been direction changed: {}", in);
    }

    private static Boolean isInBoundaries(Box box, Point roverPosition) {
        Point first = box.getFirst();
        Point second = box.getSecond();

        return (roverPosition.getX() >= first.getX() && roverPosition.getX() <= second.getX())
                && (roverPosition.getY() <= second.getY() && roverPosition.getY() >= first.getY());
    }
}
