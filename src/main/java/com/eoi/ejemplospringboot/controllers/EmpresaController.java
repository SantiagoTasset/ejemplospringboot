package com.eoi.ejemplospringboot.controllers;

import com.eoi.ejemplospringboot.entities.Empresa;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/empresas")
public class EmpresaController {

    @Autowired
    EmpresaService empresaService;

    @Autowired
    public EmpresaController(EmpresaService empresaService) {
        this.empresaService = empresaService;
    }

    @GetMapping
    public List<Empresa> obtenerTodasLasEmpresas() {
        return empresaService.obtenerTodasLasEmpresas();
    }

    @GetMapping("/{id}")
    public Empresa obtenerEmpresaPorId(@PathVariable Integer id) {
        return empresaService.obtenerEmpresaPorId(id);
    }

    @PostMapping
    public Empresa crearEmpresa(@RequestBody Empresa empresa) {
        return empresaService.crearEmpresa(empresa);
    }

    @PutMapping("/{id}")
    public Empresa actualizarEmpresa(@PathVariable Integer id, @RequestBody Empresa empresa) {
        return empresaService.actualizarEmpresa(id, empresa);
    }

    @DeleteMapping("/{id}")
    public void eliminarEmpresa(@PathVariable Integer id) {
        empresaService.eliminarEmpresa(id);
    }
}

