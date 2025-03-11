package com.ms.plantilla.commsplantilla.controller;

import com.ms.plantilla.commsplantilla.dto.request.EstadoRequestDto;
import com.ms.plantilla.commsplantilla.handler.response.ResponseOk;
import com.ms.plantilla.commsplantilla.service.IService.IEstadoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/estados")
@Tag(name = "Estados", description = "API para gestión de estados")
public class EstadoController {

    @Autowired
    private IEstadoService estadoService;

    @Operation(summary = "Obtener todos los estados")
    @GetMapping
    public ResponseEntity<ResponseOk> obtenerEstados() {
        return ResponseEntity.ok(ResponseOk.builder()
                .mensaje("Lista de estados obtenida exitosamente")
                .resultado(estadoService.obtenerEstados())
                .build());
    }
}