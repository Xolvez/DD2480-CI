package com.example.backend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.backend.utils.ProcessGenerator;

@SpringBootApplication
public class BackendApplication {

	public static void main(String[] args) {
		ProcessGenerator pg = new ProcessGenerator();
		pg.compileProject();
		System.out.println(pg.getStatus());
		SpringApplication.run(BackendApplication.class, args);
	}

}
