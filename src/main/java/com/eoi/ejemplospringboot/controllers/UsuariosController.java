package com.eoi.ejemplospringboot.controllers;


import com.eoi.ejemplospringboot.entities.Usuario;
import com.eoi.ejemplospringboot.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * Controlador encargado de manejar las peticiones relacionadas con los usuarios.
 */
@Controller
@RequestMapping("/usuarios")
public class UsuariosController {

    /**
     * Repositorio utilizado para realizar operaciones con la base de datos relacionadas con los usuarios.
     */
    @Autowired
    UsuarioRepository usuarioRepository;

    /**
     * Método encargado de mostrar la página principal de usuarios, la cual contendrá una lista de todos los usuarios registrados.
     * @param model objeto modelo utilizado para pasar información a la vista.
     * @return el nombre de la vista que se debe mostrar.
     */
    @GetMapping(value={"","/"})
    public String mostrarIndex(Model model)
    {
        // Recupera la lista de todos los usuarios registrados en la base de datos.
        List<Usuario> listaUsuarios = usuarioRepository.findAll();

        // Se añade la lista de usuarios al modelo para que la vista pueda acceder a ella.
        model.addAttribute("listaUsuarios",listaUsuarios);

        // Retorna el nombre de la vista que se debe mostrar.
        return "usuarios/index";
    }

}

