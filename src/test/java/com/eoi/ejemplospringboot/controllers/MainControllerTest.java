package com.eoi.ejemplospringboot.controllers;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

/**
 * Clase de prueba para el controlador principal (MainController).
 */
@WebMvcTest(MainController.class) // Anotación que indica que se realizará una prueba de integración del controlador MainController
@ContextConfiguration(classes = {MainController.class}) // Anotación que especifica la configuración de contexto para la prueba
class MainControllerTest {

    @Autowired
    private MockMvc mockMvc; // Objeto MockMvc para realizar solicitudes HTTP simuladas

    /**
     * Prueba del método showIndex() del controlador para la ruta "/".
     * Verifica que la respuesta sea exitosa (código de estado 200) y que la vista retornada sea "holamundo.html".
     */
    @Test
    void testShowIndex() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/")) // Realiza una solicitud GET a la ruta "/"
                .andExpect(MockMvcResultMatchers.status().isOk()) // Verifica que el código de estado de la respuesta sea 200 (OK)
                .andExpect(MockMvcResultMatchers.view().name("holamundo.html")); // Verifica que la vista retornada sea "holamundo.html"
    }
}

