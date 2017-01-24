package com.nasa.rover;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.solr.repository.config.EnableSolrRepositories;

/**
 * 
 * @author eliocapelati
 *
 */
@SpringBootApplication
@EnableSolrRepositories(basePackages = {"com.nasa.rover.repository" }, multicoreSupport = true, schemaCreationSupport = true)
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
}
