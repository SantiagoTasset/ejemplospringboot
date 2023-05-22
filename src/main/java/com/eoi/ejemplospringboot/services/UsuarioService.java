package com.eoi.ejemplospringboot.services;

import com.eoi.ejemplospringboot.abstractcomponents.GenericServiceWithJPA;
import com.eoi.ejemplospringboot.entities.Usuario;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;

import java.awt.*;

@Component
public class UsuarioService extends GenericServiceWithJPA<Usuario, Integer> {


}

