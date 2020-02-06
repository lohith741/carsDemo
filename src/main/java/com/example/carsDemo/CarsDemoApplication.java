package com.example.carsDemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class CarsDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CarsDemoApplication.class, args);
	}

}
