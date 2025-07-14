package cl.gallardo_molina.tiendacelulares.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import cl.gallardo_molina.tiendacelulares.service.AdminService;

@RestController
@RequestMapping("/api/admin")
public class AdminController {
    private final AdminService adminService;

    public AdminController(AdminService adminService) {
        this.adminService = adminService;
    }

    @DeleteMapping("/reset")
    public String resetDatabase() {
        adminService.resetDatabase();
        return "Base de datos borrada correctamente";
    }
    
    @PostMapping("/cargar")
    public String cargarDatos() {
    adminService.cargarBaseDeDatos();
    return "Base de datos cargada correctamente";
    }
}
