package com.eoi.ejemplospringboot.controllers;


import com.eoi.ejemplospringboot.entities.Usuario;
import com.eoi.ejemplospringboot.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class MainController {


    @GetMapping(value={"","/"})
    public String mostrarIndex()
    {
        return "index";
    }

    @GetMapping("/holamundo")
    public String holaMundo()
    {
        return "holamundo.html";
    }




}
