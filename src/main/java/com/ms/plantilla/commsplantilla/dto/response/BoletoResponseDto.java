package com.ms.plantilla.commsplantilla.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@Builder
@AllArgsConstructor
public class BoletoResponseDto {
    private String codigoQr;
    private String numeroAsiento;
    private String nombrePasajero;
    private BigDecimal precio;
    private String estado;
    private LocalDateTime fechaEmision;
    private ViajeInfoDto viaje;
}
