package cl.gallardo_molina.tiendacelulares.service;

import java.util.List;
import org.springframework.stereotype.Service;

import cl.gallardo_molina.tiendacelulares.dto.CelularDTO;
import cl.gallardo_molina.tiendacelulares.entity.Celular;
import cl.gallardo_molina.tiendacelulares.entity.Marca;
import cl.gallardo_molina.tiendacelulares.repository.CelularRepository;
import cl.gallardo_molina.tiendacelulares.repository.MarcaRepository;

@Service
public class CelularService {
    private final CelularRepository celularRepo;
    private final MarcaRepository marcaRepo;

    public CelularService(CelularRepository celularRepo, MarcaRepository marcaRepo) {
        this.celularRepo = celularRepo;
        this.marcaRepo = marcaRepo;
    }

    public Celular crearCelular(CelularDTO dto) {
        Marca marca = marcaRepo.findById(dto.getMarcaId()).orElseThrow();
        Celular celular = new Celular(null, dto.getModelo(), dto.getPrecio(), marca);
        return celularRepo.save(celular);
    }

    public List<Celular> listarCelulares() {
        return celularRepo.findAll();
    }

    public Celular actualizarCelular(Long id, CelularDTO dto) {
        Celular celular = celularRepo.findById(id)
            .orElseThrow(() -> new RuntimeException("Celular no encontrado"));
    
        Marca marca = marcaRepo.findById(dto.getMarcaId())
            .orElseThrow(() -> new RuntimeException("Marca no encontrada"));
    
        celular.setModelo(dto.getModelo());
        celular.setPrecio(dto.getPrecio());
        celular.setMarca(marca);
    
        return celularRepo.save(celular);
    }
    
    public void eliminarCelular(Long id) {
        celularRepo.deleteById(id);
    }

}
