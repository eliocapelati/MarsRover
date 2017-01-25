package com.nasa.rover.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.nasa.rover.service.RoverService;
import com.nasa.rover.service.RoverServiceException;

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
    public String hello(@RequestParam("rover") String rover) throws RoverServiceException  {
        return service.processRover(rover);
    }
}
