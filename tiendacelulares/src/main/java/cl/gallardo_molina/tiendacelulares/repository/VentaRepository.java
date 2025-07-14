package cl.gallardo_molina.tiendacelulares.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import cl.gallardo_molina.tiendacelulares.entity.Venta;

public interface VentaRepository extends JpaRepository<Venta, Long> {

}
