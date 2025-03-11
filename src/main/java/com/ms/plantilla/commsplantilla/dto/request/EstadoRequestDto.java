package com.ms.plantilla.commsplantilla.dto.request;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class EstadoRequestDto {
    @NotBlank(message = "El nombre es requerido")
    private String nombre;

    @NotBlank(message = "La zona horaria es requerida")
    private String zonaHoraria;
}
