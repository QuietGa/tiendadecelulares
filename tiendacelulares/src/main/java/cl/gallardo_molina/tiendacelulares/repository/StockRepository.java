package cl.gallardo_molina.tiendacelulares.repository;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import cl.gallardo_molina.tiendacelulares.entity.Stock;

public interface StockRepository extends JpaRepository<Stock, Long> {
    Optional<Stock> findByCelularId(Long celularId);
}
