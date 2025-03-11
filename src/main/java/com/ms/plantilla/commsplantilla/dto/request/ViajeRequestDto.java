package com.ms.plantilla.commsplantilla.dto.request;

import jakarta.validation.constraints.NotNull;
import lombok.Data;
import java.time.LocalDateTime;

@Data
public class ViajeRequestDto {
    @NotNull(message = "La ruta es requerida")
    private Long rutaId;

    @NotNull(message = "El autobús es requerido")
    private Long autobusId;

    @NotNull(message = "La fecha de salida es requerida")
    private LocalDateTime fechaSalida;

    @NotNull(message = "La fecha de llegada es requerida")
    private LocalDateTime fechaLlegada;
}