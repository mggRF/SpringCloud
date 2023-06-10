package com.repo.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@SpringBootApplication
@EnableConfigServer
public class ClientConfig1Application {

	public static void main(String[] args) {
		SpringApplication.run(ClientConfig1Application.class, args);
	}

}
