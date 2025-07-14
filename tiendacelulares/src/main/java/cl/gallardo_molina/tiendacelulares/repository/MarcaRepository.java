package cl.gallardo_molina.tiendacelulares.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import cl.gallardo_molina.tiendacelulares.entity.Marca;

public interface MarcaRepository extends JpaRepository<Marca, Long> {

}
