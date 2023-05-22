package com.eoi.ejemplospringboot.services;

import com.eoi.ejemplospringboot.abstractcomponents.GenericServiceWithJPA;
import com.eoi.ejemplospringboot.entities.Usuario;
import org.springframework.stereotype.Component;

@Component
public class UsuarioService extends GenericServiceWithJPA<Usuario, Integer> {


}

