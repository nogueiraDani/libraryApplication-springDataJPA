package com.project.dani.library_app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;

@SpringBootApplication
@OpenAPIDefinition(info = @Info(title = "Library API", version = "1.0", description = "Documentation of Library API"))
public class LibraryApp {

	public static void main(String[] args) {
		SpringApplication.run(LibraryApp.class, args);
	}

}
