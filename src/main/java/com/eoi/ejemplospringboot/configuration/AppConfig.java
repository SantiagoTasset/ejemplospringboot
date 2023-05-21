package com.eoi.ejemplospringboot.configuration;

import com.eoi.ejemplospringboot.abstractcomponents.GenericServiceWithJPA;
import com.eoi.ejemplospringboot.controllers.UsuarioController;
import com.eoi.ejemplospringboot.entities.Usuario;
import com.eoi.ejemplospringboot.services.UsuarioService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {


    @Bean
    public UsuarioController usuarioController() {

        String entityName = "usuario";
        return new UsuarioController(entityName);

    }





}
