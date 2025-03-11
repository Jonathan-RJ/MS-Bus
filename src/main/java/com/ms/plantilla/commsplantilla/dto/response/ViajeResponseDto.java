package com.ms.plantilla.commsplantilla.dto.response;

import lombok.Data;
import java.time.LocalDateTime;

@Data
public class ViajeResponseDto {
    private String folio;
    private String origen;
    private String destino;
    private LocalDateTime fechaSalida;
    private LocalDateTime fechaLlegada;
    private String estado;
    private String numeroAutobus;

    // Constructor que coincide exactamente con la consulta JPQL
    public ViajeResponseDto(
            String folio,
            String origen,
            String destino,
            LocalDateTime fechaSalida,
            LocalDateTime fechaLlegada,
            String estado,
            String numeroAutobus) {
        this.folio = folio;
        this.origen = origen;
        this.destino = destino;
        this.fechaSalida = fechaSalida;
        this.fechaLlegada = fechaLlegada;
        this.estado = estado;
        this.numeroAutobus = numeroAutobus;
    }

    public ViajeResponseDto() {
    }
}