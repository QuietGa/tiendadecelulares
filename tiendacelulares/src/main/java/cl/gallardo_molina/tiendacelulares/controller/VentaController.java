package cl.gallardo_molina.tiendacelulares.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cl.gallardo_molina.tiendacelulares.dto.VentaDTO;
import cl.gallardo_molina.tiendacelulares.entity.Venta;
import cl.gallardo_molina.tiendacelulares.service.VentaService;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/ventas")
public class VentaController {

    private final VentaService ventaService;

    public VentaController(VentaService ventaService) {
        this.ventaService = ventaService;
    }

    // Se añade @Valid para validar el DTO
    @PostMapping
    public Venta registrar(@RequestBody @Valid VentaDTO dto) {
        return ventaService.registrarVenta(dto);
    }

    @GetMapping
    public List<Venta> listar() {
        return ventaService.listarVentas();
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Long id) {
    ventaService.eliminarVenta(id);
    }

    
}
