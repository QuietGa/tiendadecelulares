package cl.gallardo_molina.tiendacelulares.service;

import java.util.List;
import org.springframework.stereotype.Service;
import cl.gallardo_molina.tiendacelulares.dto.StockDTO;
import cl.gallardo_molina.tiendacelulares.entity.Celular;
import cl.gallardo_molina.tiendacelulares.entity.Stock;
import cl.gallardo_molina.tiendacelulares.repository.CelularRepository;
import cl.gallardo_molina.tiendacelulares.repository.StockRepository;

@Service
public class StockService {

    private final StockRepository stockRepo;
    private final CelularRepository celularRepo;

    public StockService(StockRepository stockRepo, CelularRepository celularRepo) {
        this.stockRepo = stockRepo;
        this.celularRepo = celularRepo;
    }

    public Stock registrarStock(StockDTO dto) {
        Celular celular = celularRepo.findById(dto.getCelularId())
                .orElseThrow(() -> new RuntimeException("Celular no encontrado"));

        Stock stock = new Stock(null, celular, dto.getCantidad());
        return stockRepo.save(stock);
    }

    public List<Stock> listarStock() {
        return stockRepo.findAll();
    }

    public Stock actualizarStock(Long id, StockDTO dto) {
        Stock stock = stockRepo.findById(id)
            .orElseThrow(() -> new RuntimeException("Stock no encontrado"));
    
        Celular celular = celularRepo.findById(dto.getCelularId())
            .orElseThrow(() -> new RuntimeException("Celular no encontrado"));
    
        stock.setCelular(celular);
        stock.setCantidad(dto.getCantidad());
    
        return stockRepo.save(stock);
    }
    
    public void eliminarStock(Long id) {
        stockRepo.deleteById(id);
    }
}
