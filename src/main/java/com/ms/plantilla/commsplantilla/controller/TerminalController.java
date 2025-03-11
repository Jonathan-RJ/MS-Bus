package com.ms.plantilla.commsplantilla.controller;

import com.ms.plantilla.commsplantilla.dto.request.TerminalRequestDto;
import com.ms.plantilla.commsplantilla.handler.response.ResponseOk;
import com.ms.plantilla.commsplantilla.service.IService.ITerminalService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/terminales")
@Tag(name = "Terminales", description = "API para gestión de terminales de autobuses")
public class TerminalController {

    @Autowired
    private ITerminalService terminalService;

    @Operation(summary = "Obtener todas las terminales con información completa")
    @GetMapping
    public ResponseOk obtenerTodasLasTerminales() {
        return terminalService.obtenerTodasLasTerminales();
    }

}