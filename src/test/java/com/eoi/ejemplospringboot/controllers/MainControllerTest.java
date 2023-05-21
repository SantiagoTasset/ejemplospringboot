package com.eoi.ejemplospringboot.controllers;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
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
@RunWith(SpringRunner.class)
@SpringBootTest(classes= MainController.class)
@AutoConfigureMockMvc
class MainControllerTest {

    @Autowired
    private MockMvc mockMvc; // Objeto MockMvc para realizar solicitudes HTTP simuladas

    /**
     * Prueba del método holaMundo() del controlador para la ruta "/holamundo".
     * Verifica que la respuesta sea exitosa (código de estado 200) y que la vista retornada sea "holamundo.html".
     */
    @Test
    void testHolaMundo() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/holamundo")) // Realiza una solicitud GET a la ruta "/holamundo"
                .andExpect(MockMvcResultMatchers.status().isOk()) // Verifica que el código de estado de la respuesta sea 200 (OK)
                .andExpect(MockMvcResultMatchers.view().name("holamundo.html")); // Verifica que la vista retornada sea "holamundo.html"
    }

    /**
     * Prueba del método mainPage() del controlador para la ruta "".
     * Verifica que la respuesta sea exitosa (código de estado 200) y que la vista retornada sea "index".
     */
    @Test
    void testMainPage() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("")) // Realiza una solicitud GET a la ruta ""
                .andExpect(MockMvcResultMatchers.status().isOk()) // Verifica que el código de estado de la respuesta sea 200 (OK)
                .andExpect(MockMvcResultMatchers.view().name("index")); // Verifica que la vista retornada sea "index"
    }

}

