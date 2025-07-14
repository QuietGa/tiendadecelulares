package cl.gallardo_molina.tiendacelulares.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Data;

@Data
public class ItemVentaDTO {
    @NotNull(message = "El celular no puede estar vacío")
    private Long celularId;
    
    @Positive(message = "La cantidad debe ser mayor a 0")
    private int cantidad;

}
