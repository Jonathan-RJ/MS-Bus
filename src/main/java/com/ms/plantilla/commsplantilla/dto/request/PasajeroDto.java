package com.ms.plantilla.commsplantilla.dto.request;

import jakarta.validation.constraints.*;
import lombok.Data;

@Data
public class PasajeroDto {
    @NotBlank(message = "El nombre es requerido")
    private String nombre;

    @NotBlank(message = "Los apellidos son requeridos")
    private String apellidos;

    @NotNull(message = "El tipo de persona es requerido")
    private Long tipoPersonaId;

    private String email;

    private String telefono;
}
