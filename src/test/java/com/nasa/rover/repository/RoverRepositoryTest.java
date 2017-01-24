package com.nasa.rover.repository;

import static org.junit.Assert.*;

import java.util.Iterator;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.nasa.rover.model.Rover;
import com.nasa.rover.parser.InputParser;
import com.nasa.rover.parser.InputParserException;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RoverRepositoryTest {

	@Autowired
	private RoverRepository roverRepository;
	
	@Before
	public void setup(){
		roverRepository.deleteAll();
	}
	@After
	public void tearDown(){
		roverRepository.deleteAll();
	}
	
	@Test
	public void testSaveToSolr() throws InputParserException {
		String test = "5 5\n"
				+ "1 2 N\n"
				+ "MMRMMRMRRM";
		List<Rover> parse = InputParser.builder().withInput(test).build().parse();
		Iterable<Rover> save = roverRepository.save(parse);
		
		assertNotNull(save);
		Iterator<Rover> iparse = parse.iterator();
		Iterator<Rover> isave = save.iterator();
		while(iparse.hasNext() && isave.hasNext()){
			assertEquals(iparse.next(), isave.next());
		}
		
	}

}
