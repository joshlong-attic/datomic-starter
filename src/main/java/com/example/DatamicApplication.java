package com.example;

import datomic.Connection;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class DatamicApplication {

	// demonstrates contributing a Connection directly
	@Bean
	Connection customConnection (){
		return new Connection("some:url:please");
	}

	public static void main(String[] args) {
		SpringApplication.run(DatamicApplication.class, args);
	}
}
