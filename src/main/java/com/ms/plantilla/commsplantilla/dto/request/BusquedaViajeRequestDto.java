package com.ms.plantilla.commsplantilla.dto.request;

import jakarta.validation.constraints.NotNull;
import lombok.Data;
import java.time.LocalDate;

@Data
public class BusquedaViajeRequestDto {
    @NotNull(message = "La fecha es requerida")
    private LocalDate fecha;

    @NotNull(message = "El terminal de origen es requerido")
    private Long origenTerminalId;

    @NotNull(message = "El terminal de destino es requerido")
    private Long destinoTerminalId;
}