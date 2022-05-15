package com.example.restservice;

import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.Serializable;
import java.util.logging.Logger;

@SpringBootApplication
public class RestServiceApplication implements Serializable {

	public static void main(String[] args) {
		SpringApplication.run(RestServiceApplication.class, args);
	}

}
