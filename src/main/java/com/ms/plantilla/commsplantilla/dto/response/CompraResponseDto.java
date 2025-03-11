package com.ms.plantilla.commsplantilla.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
public class CompraResponseDto {
    private String referencia;
    private LocalDateTime fechaCompra;
    private String estado;
    private String metodoPago;
    private BigDecimal totalMonto;
    private List<BoletoResponseDto> boletos;
}