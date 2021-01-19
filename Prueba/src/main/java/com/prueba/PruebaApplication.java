package com.prueba;

import java.sql.SQLException;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import Proceso.Procesos;

@SpringBootApplication
public class PruebaApplication {

	public static void main(String[] args) throws SQLException {
		SpringApplication.run(PruebaApplication.class, args);
		Procesos.listado();
	}

}
