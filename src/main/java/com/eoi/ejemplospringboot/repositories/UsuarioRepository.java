package com.eoi.ejemplospringboot.repositories;

import com.eoi.ejemplospringboot.entities.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {

}