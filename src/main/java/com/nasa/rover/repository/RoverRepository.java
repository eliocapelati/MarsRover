package com.nasa.rover.repository;

import org.springframework.data.solr.repository.SolrCrudRepository;

import com.nasa.rover.model.Rover;

/**
 * 
 * @author eliocapelati
 *
 */
public interface RoverRepository extends SolrCrudRepository<Rover, String> {
	public Rover findById(String id);
}
