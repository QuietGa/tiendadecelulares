package cl.gallardo_molina.tiendacelulares.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import cl.gallardo_molina.tiendacelulares.entity.Celular;

public interface CelularRepository extends JpaRepository<Celular, Long> {

}
