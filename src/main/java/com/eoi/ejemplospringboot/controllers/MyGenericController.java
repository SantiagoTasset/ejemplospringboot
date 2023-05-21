package com.eoi.ejemplospringboot.controllers;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;

public interface MyGenericController<T, ID> {

    JpaRepository<T, ID> repository;

    @GetMapping("/all")
    ResponseEntity<List<T>> findAll();

    @GetMapping("/{id}")
    ResponseEntity<T> getById(@PathVariable ID id);

    @PostMapping
    ResponseEntity<T> create(@RequestBody T entity);

    @PutMapping("/{id}")
    ResponseEntity<T> update(@PathVariable ID id, @RequestBody T entity);

    @DeleteMapping("/{id}")
    ResponseEntity<Void> delete(@PathVariable ID id);

    // Otros métodos genéricos comunes a los controladores



}

