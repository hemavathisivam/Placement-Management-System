package com.example.placementmanagement;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan(basePackages = "com.example.placementmanagement.model")
public class PlacementmanagementApplication {

	public static void main(String[] args) {
		SpringApplication.run(PlacementmanagementApplication.class, args);
	}

}
