package cl.gallardo_molina.tiendacelulares.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class ClienteDTO {
    @NotBlank(message = "El nombre no puede estar vacío")
    private String nombre;

    @NotBlank(message = "El teléfono no puede estar vacío")
    private String telefono;

    @NotBlank(message = "El RUT no puede estar vacío")
    private int rut; 

    @NotBlank(message = "El dígito verificador no puede estar vacío")
    private String dv;
}
