package com.example.Assigment1_Omar;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan("class com.example.Assigment1_Omar.model")

public class Assigment1OmarApplication {

	public static void main(String[] args) {
		SpringApplication.run(Assigment1OmarApplication.class, args);
	}

}
