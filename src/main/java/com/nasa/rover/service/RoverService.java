package com.nasa.rover.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import com.nasa.rover.logic.MakeMovement;
import com.nasa.rover.logic.OutOfBoundaryException;
import com.nasa.rover.model.Rover;
import com.nasa.rover.parser.InputParser;
import com.nasa.rover.parser.InputParserException;
import com.nasa.rover.repository.RoverRepository;

/**
 * 
 * @author eliocapelati
 *
 */
@Service("roverService")
public class RoverService {

    private static final Logger log = LoggerFactory.getLogger(RoverService.class);

    @Autowired
    private RoverRepository repository;

    public String processRover(String input) throws RoverServiceException {
        log.trace("Processing the input: {}", input);

        List<Rover> rovers;
        try {
            rovers = InputParser.builder().withInput(input).build().parse();
        } catch (InputParserException e) {
           throw new RoverServiceException(e);
        }
        log.debug("Rovers parsed amount {}, rover list: {}", rovers.size(), rovers);

        StringBuilder builder = new StringBuilder();

        MakeMovement makeMovement = new MakeMovement();

        for (Rover rover : rovers) {
            try {
                makeMovement.move(rover);
            } catch (OutOfBoundaryException e) {
                throw new RoverServiceException(e);
            }
            log.debug("Rover moved {}", rover);
            builder.append(String.format("%1.0f %1.0f %s", rover.getEndPoint().getX(), rover.getEndPoint().getY(),
                    rover.getEndDirection())).append("\n");
        }
        log.debug("All rovers processed: {}", rovers);

        saveAsyncRover(rovers);
        log.debug("Response: {}", builder);

        return builder.toString();
    }
    
    @Async
    public void saveAsyncRover(List<Rover> rovers){
        repository.save(rovers);
        log.debug("Saved rovers: {}", rovers.size());
    }

}
