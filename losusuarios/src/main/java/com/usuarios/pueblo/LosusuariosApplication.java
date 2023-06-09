package com.usuarios.pueblo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class LosusuariosApplication {

	public static void main(String[] args) {
		SpringApplication.run(LosusuariosApplication.class, args);
	}

}
