package com.nasa.rover.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.nasa.rover.logic.OutOfBoundaryException;
import com.nasa.rover.parser.InputParserException;
import com.nasa.rover.service.RoverService;

/**
 * 
 * @author eliocapelati
 *
 */
@RestController
public class RoverController {

    

    @Autowired
    private RoverService service;

    @RequestMapping(path = "/", method = RequestMethod.POST)
    public String hello(@RequestParam("rover") String rover) throws InputParserException, OutOfBoundaryException {
        return service.processRover(rover);
    }
}
