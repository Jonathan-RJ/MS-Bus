package com.ms.plantilla.commsplantilla.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class TerminalCompletoDTO {
    private Long id;
    private String descripcion;
}