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

import cl.gallardo_molina.tiendacelulares.entity.Cliente;
import cl.gallardo_molina.tiendacelulares.repository.ClienteRepository;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/clientes")
public class ClienteController {
    private final ClienteRepository clienteRepo;

    public ClienteController(ClienteRepository clienteRepo) {
        this.clienteRepo = clienteRepo;
    }

    @PostMapping
    public Cliente crearCliente(@RequestBody @Valid Cliente cliente) {
        return clienteRepo.save(cliente);
    }

    @GetMapping
    public List<Cliente> listarClientes() {
        return clienteRepo.findAll();
    }

    @PutMapping("/{id}")
    public Cliente actualizar(@PathVariable Long id, @RequestBody @Valid Cliente datos) {
    return clienteRepo.findById(id).map(cliente -> {
        cliente.setNombre(datos.getNombre());
        cliente.setTelefono(datos.getTelefono());
        cliente.setRut(datos.getRut());
        cliente.setDv(datos.getDv());
        return clienteRepo.save(cliente);
    }).orElseThrow(() -> new RuntimeException("Cliente no encontrado"));
    }

    @DeleteMapping("/{id}")
    public void eliminarCliente(@PathVariable Long id) {
    clienteRepo.deleteById(id);
    }
}
