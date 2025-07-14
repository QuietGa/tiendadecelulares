package cl.gallardo_molina.tiendacelulares.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class StockDTO {
    @NotNull(message = "Debe haber un telefono")
    private Long celularId;

    @Min(value = 0, message = "La cantidad no puede ser negativa")
    private int cantidad;
}
