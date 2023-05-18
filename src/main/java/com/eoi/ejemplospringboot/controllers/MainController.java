package com.eoi.ejemplospringboot.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Controlador principal de la aplicación.
 */
@Controller
public class MainController {

    /**
     * Maneja la solicitud GET para mostrar la página de inicio.
     *
     * @return el nombre de la plantilla HTML para mostrar la página de inicio
     */
    @GetMapping(value={"/",""})
    public String showIndex(){
        return "holamundo.html";
    }

}
