package com.eoi.ejemplospringboot.controllers;

import com.eoi.ejemplospringboot.entities.Usuario;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import java.util.ArrayList;
import java.util.List;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest(classes= UsuariosController.class)
@AutoConfigureMockMvc
class UsuariosControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private UsuarioRepository usuarioRepository;

    @Test
    void testListarUsuarios() throws Exception {
        // Crear una lista de usuarios para simular los datos obtenidos del repositorio
        List<Usuario> listaUsuarios = new ArrayList<>();
        listaUsuarios.add(new Usuario(1, "Usuario1", "Apellido1","usuario1", new ArrayList<>()));
        listaUsuarios.add(new Usuario(2, "Usuario2", "Apellido2", "usuario2",new ArrayList<>()));

        // Configurar el comportamiento esperado del repositorio mock
        when(usuarioRepository.findAll()).thenReturn(listaUsuarios);

        // Realizar la solicitud GET a la ruta del controlador
        mockMvc.perform(MockMvcRequestBuilders.get("/usuarios"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(view().name("usuarios/index"))
                .andExpect(model().attribute("listaUsuarios", listaUsuarios));

        // Verificar que se haya llamado al método findAll() del repositorio
        verify(usuarioRepository).findAll();
    }
}
