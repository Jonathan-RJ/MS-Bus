package com.ms.plantilla.commsplantilla.controller;

import com.ms.plantilla.commsplantilla.dto.request.CiudadRequestDto;
import com.ms.plantilla.commsplantilla.handler.response.ResponseOk;
import com.ms.plantilla.commsplantilla.service.IService.ICiudadService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
    @RequestMapping("/api/v1/ciudades")
@Tag(name = "Ciudades", description = "API para gestión de ciudades")
public class CiudadController {

    @Autowired
    private ICiudadService ciudadService;

    @Operation(summary = "Obtener ciudades por estado")
    @GetMapping()
    public ResponseOk obtenerCiudadesPorEstado() {
        return ciudadService.obtenerCiudades();
    }

}