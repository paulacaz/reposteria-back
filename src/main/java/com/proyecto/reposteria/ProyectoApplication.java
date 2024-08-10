package com.proyecto.reposteria;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Locale;

@SpringBootApplication
public class ProyectoApplication {

	public static void main(String[] args) {
		Locale.setDefault(new Locale("es", "CO"));
		SpringApplication.run(ProyectoApplication.class, args);
	}

}
