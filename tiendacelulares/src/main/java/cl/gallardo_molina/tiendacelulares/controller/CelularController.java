package cl.gallardo_molina.tiendacelulares.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cl.gallardo_molina.tiendacelulares.dto.CelularDTO;
import cl.gallardo_molina.tiendacelulares.entity.Celular;
import cl.gallardo_molina.tiendacelulares.service.CelularService;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/celulares")
public class CelularController {

    private final CelularService celularService;

    public CelularController(CelularService celularService) {
        this.celularService = celularService;
    }

    @PostMapping
    public Celular crearCelular(@RequestBody CelularDTO dto) {
        return celularService.crearCelular(dto);
    }

    @GetMapping
    public List<Celular> listar() {
        return celularService.listarCelulares();
    }
    
    @PutMapping("/{id}")
    public Celular actualizarCelular(@PathVariable Long id, @RequestBody @Valid CelularDTO dto) {
    return celularService.actualizarCelular(id, dto);
    }

    @DeleteMapping("/{id}")
    public void eliminarCelular(@PathVariable Long id) {
    celularService.eliminarCelular(id);
    }

}
