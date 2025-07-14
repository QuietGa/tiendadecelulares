package cl.gallardo_molina.tiendacelulares.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Data;

@Data
public class CelularDTO {
    @NotBlank(message = "El modelo no puede estar vacío")
    private String modelo;

    @Positive(message = "El precio debe ser mayor a 0")
    private int precio;

    @NotNull(message = "Debe tener una marca")
    private Long marcaId;

}
