package com.eoi.ejemplospringboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Clase principal de la aplicación Spring Boot.
 *
 * La anotación @SpringBootApplication se utiliza para marcar la clase principal de la aplicación Spring Boot.
 * Esta anotación combina múltiples anotaciones, como @Configuration, @EnableAutoConfiguration y @ComponentScan
 * para proporcionar una configuración y arranque automáticos de la aplicación Spring Boot.
 * Proporciona una forma conveniente de configurar y lanzar una aplicación Spring Boot sin la necesidad
 * de una configuración manual exhaustiva.
 *
 */
@SpringBootApplication
public class EjemplospringbootApplication {

	/**
	 * Punto de entrada principal de la aplicación.
	 *
	 * @param args los argumentos de línea de comandos
	 */
	public static void main(String[] args) {
		SpringApplication.run(EjemplospringbootApplication.class, args);
	}

}

