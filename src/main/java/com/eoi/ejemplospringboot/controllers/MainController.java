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

    @Autowired
    UsuarioRepository usuarioRepository;

    @GetMapping(value={"","/"})
    public String mostrarIndex()
    {
        return "templates/index.html";
    }

    @GetMapping("/personal")
    public String showPersonal(){
        return "personal.html";
    }

    @GetMapping("/listausuarios")
    public String showListaUsuarios(Model model){

        List<Usuario> listaUsuarios = usuarioRepository.findAll();
        model.addAttribute("listaUsuarios",listaUsuarios);

        return "listaUsuarios.html";
    }

}
