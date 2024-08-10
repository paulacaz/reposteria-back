package com.proyecto.reposteria;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.test.context.TestConfiguration;

@TestConfiguration(proxyBeanMethods = false)
public class TestProyectoApplication {

	public static void main(String[] args) {
		SpringApplication.from(ProyectoApplication::main).with(TestProyectoApplication.class).run(args);
	}

}
