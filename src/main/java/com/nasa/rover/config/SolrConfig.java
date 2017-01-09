package com.nasa.rover.config;

import org.apache.solr.client.solrj.SolrClient;
import org.apache.solr.client.solrj.impl.HttpSolrClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.solr.repository.config.EnableSolrRepositories;

@Configuration
@EnableSolrRepositories(basePackages={"com.nasa.rover.domain"}, multicoreSupport=true)
public class SolrConfig {
	
	@Value("${solr.host}")
	private String solrHost;
	
	
	/**
	 * Creates a new client of Solr based on variable <code>solr.host</code.
	 * @return {@link SolrClient}
	 */
	@Bean
	public SolrClient solrClient(){
		return new HttpSolrClient(solrHost);
	}
	
	

}
