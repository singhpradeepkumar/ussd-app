package com.ussd.ussdapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages="com.ussd")
public class UssdAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(UssdAppApplication.class, args);
	}

}
