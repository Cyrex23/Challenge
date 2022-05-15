package com.example.calculator;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.Serializable;

@SpringBootApplication
public class CalculatorApplication implements Serializable {

	public static void main(String[] args) {
		SpringApplication.run(CalculatorApplication.class, args);
	}

}
