package com.eoi.ejemplospringboot.controllers;

import com.eoi.ejemplospringboot.entities.Usuario;
import com.eoi.ejemplospringboot.services.UsuarioService;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

/**
 * Clase de prueba para el controlador principal (MainController).
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
class MainControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private UsuarioService usuarioService;

    @Test
    void testHolaMundo() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/holamundo"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.view().name("holamundo.html"));
    }

    @Test
    void testMainPage() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.view().name("index"));
    }

    @Test
    void testLogin() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/login"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.view().name("login"));
    }

    @Test
    void testLogin_ValidCredentials() throws Exception {
        String username = "example";
        String password = "password";

        Usuario usuario = new Usuario();
        usuario.setPassword(password);

        Mockito.when(usuarioService.getById(username)).thenReturn(usuario);

        mockMvc.perform(MockMvcRequestBuilders.post("/login")
                        .param("username", username)
                        .param("password", password))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.view().name("index"));
    }

    @Test
    void testLogin_InvalidCredentials() throws Exception {
        String username = "example";
        String password = "wrongpassword";

        Usuario usuario = new Usuario();
        usuario.setPassword("correctpassword");

        Mockito.when(usuarioService.getById(username)).thenReturn(usuario);

        mockMvc.perform(MockMvcRequestBuilders.post("/login")
                        .param("username", username)
                        .param("password", password))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.view().name("error"));
    }
}


