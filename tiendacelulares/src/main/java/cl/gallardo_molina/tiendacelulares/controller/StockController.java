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
import cl.gallardo_molina.tiendacelulares.dto.StockDTO;
import cl.gallardo_molina.tiendacelulares.entity.Stock;
import cl.gallardo_molina.tiendacelulares.service.StockService;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/stock")
public class StockController {

    private final StockService stockService;

    public StockController(StockService stockService) {
        this.stockService = stockService;
    }

    @PostMapping
    public Stock registrar(@RequestBody StockDTO dto) {
        return stockService.registrarStock(dto);
    }

    @GetMapping
    public List<Stock> listar() {
        return stockService.listarStock();
    }
    
    @PutMapping("/{id}")
    public Stock actualizarStock(@PathVariable Long id, @RequestBody @Valid StockDTO dto) {
    return stockService.actualizarStock(id, dto);
    }


    @DeleteMapping("/{id}")
    public void eliminarStock(@PathVariable Long id) {
        stockService.eliminarStock(id);
    }

}
