package com.example.restservice;

import org.slf4j.LoggerFactory;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.io.Serializable;

@SpringBootApplication
public class RestServiceApplication implements Serializable {

	@Bean
	public Jackson2JsonMessageConverter jsonConverter() {
		return new Jackson2JsonMessageConverter();
	}

	public static void main(String[] args) {
		SpringApplication.run(RestServiceApplication.class, args);
	}

}
