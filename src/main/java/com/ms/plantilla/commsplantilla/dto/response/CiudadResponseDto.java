package com.ms.plantilla.commsplantilla.dto.response;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class CiudadResponseDto {

    private Long id;
    private String descripcion;

}
