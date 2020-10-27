package com.musala.gateway;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class GatewaysApplication {

	public static final Logger logger = LoggerFactory.getLogger(GatewaysApplication.class);
	
	public static void main(String[] args) {
		SpringApplication.run(GatewaysApplication.class, args);
	}

}
