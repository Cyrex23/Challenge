package com.example.calculator;

import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.io.Serializable;

@SpringBootApplication
public class CalculatorApplication implements Serializable {

	@Bean
	public Jackson2JsonMessageConverter jsonConverter() {
		return new Jackson2JsonMessageConverter();
	}
	public static void main(String[] args) {
		SpringApplication.run(CalculatorApplication.class, args);
	}

}
