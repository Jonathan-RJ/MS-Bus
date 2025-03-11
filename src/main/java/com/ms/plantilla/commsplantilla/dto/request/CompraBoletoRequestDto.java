package com.ms.plantilla.commsplantilla.dto.request;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import java.util.List;

@Data
public class CompraBoletoRequestDto {
    @NotNull(message = "El ID del viaje es requerido")
    private Long viajeId;

    @NotEmpty(message = "Debe seleccionar al menos un asiento")
    private List<Long> asientosViajeIds;

    @NotNull(message = "El método de pago es requerido")
    private String metodoPago;

    @Valid
    @NotEmpty(message = "La información de pasajeros es requerida")
    private List<PasajeroDto> pasajeros;
}

