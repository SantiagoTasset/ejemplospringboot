package com.eoi.ejemplospringboot.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

/**
 * Clase que representa a un Usuario en el sistema.
 * Un Usuario puede estar asociado a uno o varios roles y, opcionalmente, a un Empleado.
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * Nombre de usuario del Usuario.
     */
    private String username;

    /**
     * Nombre del Usuario.
     */
    private String nombre;

    /**
     * Apellido del Usuario.
     */
    private String apellido;

    private LocalDate FechaNacimiento;

    /**
     * Lista de roles asociados al Usuario.
     */
    @OneToMany
    private List<Rol> roles;

    /**
     * Empleado asociado al Usuario (opcional).
     */
    @OneToOne(optional = true)
    private Empleado empleado;

}

