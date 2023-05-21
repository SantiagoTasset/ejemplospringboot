package com.eoi.ejemplospringboot.controllers;

import com.eoi.ejemplospringboot.errorcontrol.exceptions.MiEntidadNoEncontradaException;
import com.eoi.ejemplospringboot.services.GenericServiceWithJPA;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/{entityName}")
public class MyGenericController<T, R extends JpaRepository<T, ?>> {

    private final GenericServiceWithJPA<T, ?, R> service;

    public MyGenericController(GenericServiceWithJPA<T, ?, R> service, Class<T> entityClass) {
        this.service = service;
    }

    @GetMapping("/all")
    public String getAll(@PathVariable String entityName, Model model) {
        List<T> entities = service.listAll();
        model.addAttribute("entities", entities);
        return "all-entities"; // Nombre de la plantilla para mostrar todas las entidades
    }

    @GetMapping("/{id}")
    public String getById(@PathVariable I id, Model model) {
        try {
            T entity = service.getById(id);
            model.addAttribute("entity", entity);
            return "entity-details"; // Nombre de la plantilla para mostrar los detalles de una entidad
        } catch (MiEntidadNoEncontradaException ex) {
            model.addAttribute("mensaje", "Entidad no encontrada");
            model.addAttribute("error", ex.getMessage());
            return "error"; // Nombre de la plantilla para mostrar la página de error
        }
    }

    @PostMapping
    public String create(@RequestBody T entity, Model model) {
        T createdEntity = service.create(entity);
        model.addAttribute("entity", createdEntity);
        return "entity-details"; // Nombre de la plantilla para mostrar los detalles de la entidad creada
    }

    @PutMapping("/{id}")
    public String update(@PathVariable I id, @RequestBody T entity, Model model) {
        T updatedEntity = service.update(id, entity);
        model.addAttribute("entity", updatedEntity);
        return "entity-details"; // Nombre de la plantilla para mostrar los detalles de la entidad actualizada
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable I id) {
        service.delete(id);
        return "redirect:/{entityName}/all"; // Redireccionar a la página de listar todas las entidades después de eliminar una entidad
    }
}





