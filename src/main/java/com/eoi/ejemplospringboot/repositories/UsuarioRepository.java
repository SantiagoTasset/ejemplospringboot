package com.eoi.ejemplospringboot.repositories;

import com.eoi.ejemplospringboot.entities.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


/**
 * Repositorio para la entidad Usuario.
 * Proporciona métodos para realizar operaciones CRUD (crear, leer, actualizar, eliminar) en la base de datos.
 * Además de los métodos heredados de JpaRepository, este repositorio también define consultas personalizadas utilizando Query Methods de Spring Data JPA.
 *
 * @see org.springframework.data.jpa.repository.JpaRepository
 * @see org.springframework.data.jpa.repository.Query
 * @see org.springframework.data.repository.query.Param
 */
@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {

    /**
     * Busca un Usuario por su nombre de usuario.
     *
     * @param username El nombre de usuario a buscar.
     * @return Un Optional que contiene el Usuario si se encuentra, o vacío si no existe.
     * @see <a href="https://docs.spring.io/spring-data/jpa/docs/current/reference/html/#jpa.query-methods.query-creation">Spring Data JPA Query Methods</a>
     */
    public Optional<Usuario> findByUsername(String username);

}

