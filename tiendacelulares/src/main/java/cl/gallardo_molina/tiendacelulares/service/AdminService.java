package cl.gallardo_molina.tiendacelulares.service;

import java.time.LocalDateTime;

import org.springframework.stereotype.Service;
import cl.gallardo_molina.tiendacelulares.entity.Celular;
import cl.gallardo_molina.tiendacelulares.entity.Cliente;
import cl.gallardo_molina.tiendacelulares.entity.DetalleVenta;
import cl.gallardo_molina.tiendacelulares.entity.Marca;
import cl.gallardo_molina.tiendacelulares.entity.Stock;
import cl.gallardo_molina.tiendacelulares.entity.Venta;
import cl.gallardo_molina.tiendacelulares.repository.CelularRepository;
import cl.gallardo_molina.tiendacelulares.repository.ClienteRepository;
import cl.gallardo_molina.tiendacelulares.repository.DetalleVentaRepository;
import cl.gallardo_molina.tiendacelulares.repository.MarcaRepository;
import cl.gallardo_molina.tiendacelulares.repository.StockRepository;
import cl.gallardo_molina.tiendacelulares.repository.VentaRepository;
import jakarta.transaction.Transactional;

@Service
public class AdminService {
    private final VentaRepository ventaRepo;
    private final DetalleVentaRepository detalleRepo;
    private final ClienteRepository clienteRepo;
    private final CelularRepository celularRepo;
    private final StockRepository stockRepo;
    private final MarcaRepository marcaRepo;

    public AdminService(VentaRepository ventaRepo, DetalleVentaRepository detalleRepo,
                        ClienteRepository clienteRepo, CelularRepository celularRepo,
                        StockRepository stockRepo, MarcaRepository marcaRepo) {
        this.ventaRepo = ventaRepo;
        this.detalleRepo = detalleRepo;
        this.clienteRepo = clienteRepo;
        this.celularRepo = celularRepo;
        this.stockRepo = stockRepo;
        this.marcaRepo = marcaRepo;
    }

    @Transactional
    public void resetDatabase() {
        ventaRepo.deleteAll();
        detalleRepo.deleteAll();
        clienteRepo.deleteAll();
        stockRepo.deleteAll();
        celularRepo.deleteAll();
        marcaRepo.deleteAll();
    }

    @Transactional
    public void cargarBaseDeDatos() {
    // Crear marcas
    Marca samsung = marcaRepo.save(new Marca(null, "Samsung"));
    Marca apple = marcaRepo.save(new Marca(null, "Apple"));
    Marca xiaomi = marcaRepo.save(new Marca(null, "Xiaomi"));
    }
    
}