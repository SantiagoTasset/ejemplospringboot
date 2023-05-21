package com.eoi.ejemplospringboot.controllers;

import com.eoi.ejemplospringboot.abstractcomponents.MiControladorGenerico;

public class UsuarioController<Usuario> extends MiControladorGenerico {

    public UsuarioController(String entityName) {
        super(entityName);
    }
}
