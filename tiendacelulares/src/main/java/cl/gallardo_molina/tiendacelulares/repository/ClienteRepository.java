package cl.gallardo_molina.tiendacelulares.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import cl.gallardo_molina.tiendacelulares.entity.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {

}
