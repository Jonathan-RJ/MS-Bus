package com.ms.plantilla.commsplantilla.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class TerminalRequestDto {
    @NotNull(message = "El ID de la ciudad es requerido")
    private Long ciudadId;

    @NotBlank(message = "El nombre es requerido")
    private String nombre;

    @NotBlank(message = "La dirección es requerida")
    private String direccion;

    private String telefono;
}
