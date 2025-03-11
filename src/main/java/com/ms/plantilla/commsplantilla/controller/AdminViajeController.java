package com.ms.plantilla.commsplantilla.controller;

import com.ms.plantilla.commsplantilla.dto.request.ViajeRequestDto;
import com.ms.plantilla.commsplantilla.handler.response.ResponseOk;
import com.ms.plantilla.commsplantilla.service.IService.IViajeService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/admin/viajes")
@Tag(name = "Administración de Viajes", description = "API para gestión de viajes")
public class AdminViajeController {

    @Autowired
    private IViajeService viajeService;

    @Operation(summary = "Crear nuevo viaje")
    @PostMapping
    public ResponseEntity<ResponseOk> crearViaje(@RequestBody ViajeRequestDto viajeDto) {
        return ResponseEntity.ok(ResponseOk.builder()
                .mensaje("Viaje creado exitosamente")
                .resultado(viajeService.crearViaje(viajeDto))
                .build());
    }

    @Operation(summary = "Obtener viajes programados")
    @GetMapping("/programados")
    public ResponseEntity<ResponseOk> obtenerViajesProgramados() {
        return ResponseEntity.ok(ResponseOk.builder()
                .mensaje("Lista de viajes programados")
                .resultado(viajeService.obtenerViajesProgramados())
                .build());
    }
}
