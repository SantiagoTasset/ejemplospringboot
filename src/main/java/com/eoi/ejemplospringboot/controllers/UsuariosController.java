package com.eoi.ejemplospringboot.controllers;


import com.eoi.ejemplospringboot.entities.Usuario;

import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Optional;

/**
 * Controlador encargado de manejar las peticiones relacionadas con los usuarios.
 */
@Controller
@Getter
@Setter
@RequestMapping("/usuarios")
public class UsuariosController {

    /**
     * Repositorio utilizado para realizar operaciones con la base de datos relacionadas con los usuarios.
     */
    @Autowired
    private UsuarioService usuarioService;

    /**
     * Método encargado de mostrar la página principal de usuarios, la cual contendrá una lista de todos los usuarios registrados.
     * @param model objeto modelo utilizado para pasar información a la vista.
     * @return el nombre de la vista que se debe mostrar.
     */
    @GetMapping(value={"","/"})
    public String mostrarIndex(Model model)
    {
        // Recupera la lista de todos los usuarios registrados en la base de datos.
        List<Usuario> listaUsuarios = usuarioService.findAll();

        // Se añade la lista de usuarios al modelo para que la vista pueda acceder a ella.
        model.addAttribute("listaUsuarios",listaUsuarios);

        // Retorna el nombre de la vista que se debe mostrar.
        return "usuarios/index";
    }


    @GetMapping("/{id}")
    public String mostrarPerfilPersonal(@PathVariable Integer id, Model model) {
        // Lógica para obtener el usuario con el ID proporcionado
        Optional<Usuario> usuario= usuarioService.findById(id);
        if (usuario.isPresent()) {
            model.addAttribute("usuario", usuario.get());
            return "usuarios/perfil";

        } else {
            return "error";
        }
    }
}

