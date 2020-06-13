package com.coding;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EntityScan(basePackages = {"com.coding.model"})
@ComponentScan(basePackages = {"com.coding.controller","com.coding.util","com.coding.service","com.coding.service.impl","com.coding.handler"})
@EnableJpaRepositories(basePackages = {"com.coding.repository"})
public class RoomBookingApplication {

	public static void main(String[] args) {
		SpringApplication.run(RoomBookingApplication.class, args);
	}

}
