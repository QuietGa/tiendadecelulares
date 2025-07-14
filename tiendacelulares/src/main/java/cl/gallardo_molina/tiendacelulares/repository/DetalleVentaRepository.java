package cl.gallardo_molina.tiendacelulares.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import cl.gallardo_molina.tiendacelulares.entity.DetalleVenta;

public interface DetalleVentaRepository extends JpaRepository<DetalleVenta, Long> {

}
