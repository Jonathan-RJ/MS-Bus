package com.ms.plantilla.commsplantilla.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import java.math.BigDecimal;

@Data
@Builder
@AllArgsConstructor
public class AsientoDisponibleDto {
    private Long asientoViajeId;
    private String numeroAsiento;
    private String tipoAsiento;
    private BigDecimal precio;
    private String estado;
}