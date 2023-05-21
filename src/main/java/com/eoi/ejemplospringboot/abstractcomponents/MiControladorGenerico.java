package com.eoi.ejemplospringboot.abstractcomponents;

import com.eoi.ejemplospringboot.errorcontrol.exceptions.MiEntidadNoEncontradaException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@Controller
@RequestMapping("/{entityName}")
public abstract class MiControladorGenerico<T> {

    protected String entityName;
    protected String entityPrefix;

    @Autowired
    protected GenericServiceWithJPA<T> service;

    @Autowired
    public MiControladorGenerico(String entityName) {
        this.entityName = entityName;
        this.entityPrefix = entityName + "/";
    }


    @GetMapping("/all")
    public String getAll(Model model) {
        List<T> entities = service.listAll();
        model.addAttribute("entities", entities);
        return entityPrefix+"all-entities"; // Nombre de la plantilla para mostrar todas las entidades
    }

    @GetMapping("/{id}")
    public String getById(@PathVariable Object id, Model model) {
        try {
            T entity = service.getById(id);
            model.addAttribute("entity", entity);
            return entityPrefix+"entity-details"; // Nombre de la plantilla para mostrar los detalles de una entidad
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
        return entityPrefix+"entity-details"; // Nombre de la plantilla para mostrar los detalles de la entidad creada
    }

    @PutMapping("/{id}")
    public String update(@PathVariable Object id, @RequestBody T entity, Model model) {
        T updatedEntity = service.update(id, entity);
        model.addAttribute("entity", updatedEntity);
        return entityPrefix+"entity-details"; // Nombre de la plantilla para mostrar los detalles de la entidad actualizada
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable Object id) {
        service.delete(id);
        return "redirect:/{entityName}/all"; // Redireccionar a la página de listar todas las entidades después de eliminar una entidad
    }
}

