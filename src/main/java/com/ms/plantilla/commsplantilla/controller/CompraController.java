package com.ms.plantilla.commsplantilla.controller;

import com.ms.plantilla.commsplantilla.dto.request.CompraBoletoRequestDto;
import com.ms.plantilla.commsplantilla.handler.response.ResponseOk;
import com.ms.plantilla.commsplantilla.service.IService.ICompraService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/compras")
@Tag(name = "Compras", description = "API para realizar compras de boletos")
public class CompraController {

    @Autowired
    private ICompraService compraService;

    @Operation(summary = "Realizar compra de boletos")
    @PostMapping
    public ResponseEntity<ResponseOk> realizarCompra(@Valid @RequestBody CompraBoletoRequestDto compraDto) {
        return ResponseEntity.ok(ResponseOk.builder()
                .mensaje("Compra realizada exitosamente")
                .resultado(compraService.realizarCompra(compraDto))
                .build());
    }
}