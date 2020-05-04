package com.example.restapi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties
public class RestApiApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(RestApiApplication.class, args);
	}

	@Autowired
	LodaAppProperties lodaAppProperties;

	@Override
	public void run(String... args) throws Exception {
		System.out.println("Global variable:");
		System.out.println("\t Email: "+lodaAppProperties.getEmail());
		System.out.println("\t GA ID: "+lodaAppProperties.getGoogleAnalyticsId());
	}

}
