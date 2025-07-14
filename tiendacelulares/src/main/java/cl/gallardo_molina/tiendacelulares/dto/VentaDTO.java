package cl.gallardo_molina.tiendacelulares.dto;

import java.util.List;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class VentaDTO {
    @NotNull(message = "El cliente no puede estar vacío")
    private Long clienteId;

    @NotEmpty(message = "Debe haber al menos un celular")
    private List<ItemVentaDTO> items;
}
