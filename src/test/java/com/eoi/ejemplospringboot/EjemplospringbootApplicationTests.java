package com.eoi.ejemplospringboot;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * Pruebas de la aplicación Spring Boot.
 *
 * La anotación @SpringBootTest se utiliza para marcar la clase de prueba como una prueba de integración de Spring Boot.
 * Esta anotación permite cargar y configurar el contexto de la aplicación Spring Boot
 * para realizar pruebas en un entorno similar al entorno de ejecución real. Proporciona un conjunto de
 * características adicionales para simplificar las pruebas de integración, como la carga automática de la
 * configuración de la aplicación y la inyección de dependencias.
 *
 */
@SpringBootTest
class EjemplospringbootApplicationTests {

	/**
	 * Prueba para verificar la carga del contexto de la aplicación. Al ejecutar esta prueba, Spring Boot cargará y
	 * configurará el contexto de la aplicación.
	 * Si el contexto se carga correctamente, la prueba se considera exitosa.
	 * Esta prueba simple se utiliza a menudo como un punto de partida para asegurarse de que
	 * la configuración básica de la aplicación es correcta.
	 */
	@Test
	void contextLoads() {

	}

}
