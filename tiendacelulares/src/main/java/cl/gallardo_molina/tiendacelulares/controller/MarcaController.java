package cl.gallardo_molina.tiendacelulares.controller;

import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import cl.gallardo_molina.tiendacelulares.entity.Marca;
import cl.gallardo_molina.tiendacelulares.repository.MarcaRepository;

@RestController
@RequestMapping("/api/marcas")
public class MarcaController {

    private final MarcaRepository marcaRepo;

    public MarcaController(MarcaRepository marcaRepo) {
        this.marcaRepo = marcaRepo;
    }

    @GetMapping
    public List<Marca> listarMarcas() {
        return marcaRepo.findAll();
    }
}