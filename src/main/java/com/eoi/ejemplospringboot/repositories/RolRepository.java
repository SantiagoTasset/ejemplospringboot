package com.eoi.ejemplospringboot.repositories;

import com.eoi.ejemplospringboot.entities.Rol;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RolRepository extends JpaRepository<Rol, Integer> {
}