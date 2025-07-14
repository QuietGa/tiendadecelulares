package cl.gallardo_molina.tiendacelulares.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import cl.gallardo_molina.tiendacelulares.dto.ItemVentaDTO;
import cl.gallardo_molina.tiendacelulares.dto.VentaDTO;
import cl.gallardo_molina.tiendacelulares.entity.Celular;
import cl.gallardo_molina.tiendacelulares.entity.Cliente;
import cl.gallardo_molina.tiendacelulares.entity.DetalleVenta;
import cl.gallardo_molina.tiendacelulares.entity.Stock;
import cl.gallardo_molina.tiendacelulares.entity.Venta;
import cl.gallardo_molina.tiendacelulares.repository.CelularRepository;
import cl.gallardo_molina.tiendacelulares.repository.ClienteRepository;
import cl.gallardo_molina.tiendacelulares.repository.StockRepository;
import cl.gallardo_molina.tiendacelulares.repository.VentaRepository;

@Service
public class VentaService {

    private final VentaRepository ventaRepo;
    private final ClienteRepository clienteRepo;
    private final CelularRepository celularRepo;
    private final StockRepository stockRepo;

    public VentaService(VentaRepository ventaRepo, ClienteRepository clienteRepo,
                        CelularRepository celularRepo, StockRepository stockRepo) {
        this.ventaRepo = ventaRepo;
        this.clienteRepo = clienteRepo;
        this.celularRepo = celularRepo;
        this.stockRepo = stockRepo;
    }

    public Venta registrarVenta(VentaDTO dto) {
        Cliente cliente = clienteRepo.findById(dto.getClienteId())
                .orElseThrow(() -> new RuntimeException("Cliente no encontrado"));

        Venta venta = new Venta();
        venta.setCliente(cliente);
        //venta.setFecha(LocalDateTime.now()); ERROR: no se puede asignar LocalDateTime a LocalDate
        venta.setFecha(LocalDate.now());

        List<DetalleVenta> detalles = new ArrayList<>();
        double total = 0;

        for (ItemVentaDTO item : dto.getItems()) {
            Celular celular = celularRepo.findById(item.getCelularId())
                    .orElseThrow(() -> new RuntimeException("Celular no encontrado"));

            Stock stock = stockRepo.findByCelularId(celular.getId())
                    .orElseThrow(() -> new RuntimeException("Stock no disponible"));

            if (stock.getCantidad() < item.getCantidad()) {
                throw new RuntimeException("Stock insuficiente para " + celular.getModelo());
            }

            stock.setCantidad(stock.getCantidad() - item.getCantidad());
            stockRepo.save(stock);

            DetalleVenta detalle = new DetalleVenta();
            detalle.setVenta(venta);
            detalle.setCelular(celular);
            detalle.setCantidad(item.getCantidad());
            detalle.setPrecioUnitario(celular.getPrecio());

            detalles.add(detalle);
            total += celular.getPrecio() * item.getCantidad();
        }

        venta.setTotal(total);
        venta.setDetalles(detalles);

        return ventaRepo.save(venta); // cascade se encarga de los detalles
    }

    public List<Venta> listarVentas() {
        return ventaRepo.findAll();
    }

    public void eliminarVenta(Long id) {
    if (!ventaRepo.existsById(id)) {
        throw new RuntimeException("Venta no encontrada");
    }
    ventaRepo.deleteById(id);
    }

}
