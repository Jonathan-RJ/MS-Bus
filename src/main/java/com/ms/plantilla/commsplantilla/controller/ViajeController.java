package com.ms.plantilla.commsplantilla.controller;

import com.ms.plantilla.commsplantilla.dto.request.BusquedaViajeRequestDto;
import com.ms.plantilla.commsplantilla.handler.response.ResponseOk;
import com.ms.plantilla.commsplantilla.service.IService.IViajeService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@RestController
@RequestMapping("/api/v1/viajes")
@Tag(name = "Viajes", description = "API para gestión y búsqueda de viajes")
public class ViajeController {

    @Autowired
    private IViajeService viajeService;

    @Operation(summary = "Buscar viajes por fecha y terminales")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Búsqueda exitosa"),
            @ApiResponse(responseCode = "400", description = "Parámetros inválidos"),
            @ApiResponse(responseCode = "404", description = "No se encontraron viajes")
    })
    @GetMapping("/buscar")
    public ResponseEntity<ResponseOk> buscarViajes(
            @Parameter(description = "Fecha del viaje (YYYY-MM-DD)", required = true)
            @RequestParam LocalDate fecha,
            @Parameter(description = "ID de la terminal de origen", required = true)
            @RequestParam Long origenId,
            @Parameter(description = "ID de la terminal de destino", required = true)
            @RequestParam Long destinoId) {

        BusquedaViajeRequestDto busquedaDto = new BusquedaViajeRequestDto();
        busquedaDto.setFecha(fecha);
        busquedaDto.setOrigenTerminalId(origenId);
        busquedaDto.setDestinoTerminalId(destinoId);

        return ResponseEntity.ok(ResponseOk.builder()
                .mensaje("Viajes encontrados")
                .resultado(viajeService.buscarViajes(busquedaDto))
                .build());
    }

    @Operation(summary = "Obtener asientos disponibles para un viaje")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Consulta exitosa"),
            @ApiResponse(responseCode = "404", description = "Viaje no encontrado")
    })
    @GetMapping("/{viajeId}/asientos")
    public ResponseEntity<ResponseOk> obtenerAsientosDisponibles(
            @Parameter(description = "ID del viaje", required = true)
            @PathVariable Long viajeId) {
        return ResponseEntity.ok(ResponseOk.builder()
                .mensaje("Asientos disponibles consultados exitosamente")
                .resultado(viajeService.obtenerAsientosDisponibles(viajeId))
                .build());
    }
}