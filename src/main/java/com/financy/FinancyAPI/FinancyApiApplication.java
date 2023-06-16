package com.financy.FinancyAPI;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.servers.Server;

@OpenAPIDefinition(servers = {@Server(url = "/")})
@SpringBootApplication
public class FinancyApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(FinancyApiApplication.class, args);
	}

}
