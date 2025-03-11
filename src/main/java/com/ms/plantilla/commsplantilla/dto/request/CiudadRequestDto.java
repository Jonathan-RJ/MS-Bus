package com.ms.plantilla.commsplantilla.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class CiudadRequestDto {
    @NotNull(message = "El ID del estado es requerido")
    private Long estadoId;

    @NotBlank(message = "El nombre es requerido")
    private String nombre;
}
