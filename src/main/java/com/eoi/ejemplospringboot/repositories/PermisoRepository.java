package com.eoi.ejemplospringboot.repositories;

import com.eoi.ejemplospringboot.entities.Permiso;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PermisoRepository extends JpaRepository<Permiso, Integer> {
}