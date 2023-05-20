package com.eoi.ejemplospringboot.controllers;

import com.eoi.ejemplospringboot.entities.Usuario;
import com.eoi.ejemplospringboot.repositories.UsuarioRepository;
import org.junit.jupiter.api.Test;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import java.util.ArrayList;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class UsuariosControllerTest {

        @Test
        public void testListarUsuarios() {
            // Crear una instancia del controlador
            UsuariosController controlador = new UsuariosController();

            // Crear un objeto mock para el repositorio de usuarios
            UsuarioRepository usuarioRepository = mock(UsuarioRepository.class);

            // Crear una lista de usuarios para simular los datos obtenidos del repositorio
            List<Usuario> listaUsuarios = new ArrayList<>();
            listaUsuarios.add(new Usuario("Usuario1"));
            listaUsuarios.add(new Usuario("Usuario2"));

            // Configurar el comportamiento esperado del repositorio mock
            when(usuarioRepository.findAll()).thenReturn(listaUsuarios);

            // Crear un objeto mock para el modelo
            ModelMap model = mock(ModelMap.class);

            // Llamar al método que se va a probar
            String resultado = controlador.mostrarIndex(model);

            // Verificar que se haya agregado la lista de usuarios al modelo
            assertEquals(listaUsuarios, model.get("listaUsuarios"));

            // Verificar que se haya devuelto la vista correcta
            assertEquals("usuarios/index", resultado);
        }


}
