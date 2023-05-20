package com.example.controledegastos;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
public class ControleDeGastosApplication {

	public static void main(String[] args) {
		SpringApplication.run(ControleDeGastosApplication.class, args);
		System.out.println(new BCryptPasswordEncoder().encode("senha123"));
	}	
}
