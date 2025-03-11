package com.ms.plantilla.commsplantilla.service;

import com.ms.plantilla.commsplantilla.dto.request.CompraBoletoRequestDto;
import com.ms.plantilla.commsplantilla.dto.response.CompraResponseDto;
import com.ms.plantilla.commsplantilla.handler.exceptions.collections.HandlerRequestException400;
import com.ms.plantilla.commsplantilla.handler.exceptions.collections.HandlerRequestException404;
import com.ms.plantilla.commsplantilla.model.*;
import com.ms.plantilla.commsplantilla.model.enums.EstadoAsiento;
import com.ms.plantilla.commsplantilla.model.enums.EstadoCompra;
import com.ms.plantilla.commsplantilla.model.enums.EstadoViaje;
import com.ms.plantilla.commsplantilla.model.enums.MetodoPago;
import com.ms.plantilla.commsplantilla.repository.AsientoViajeRepository;
import com.ms.plantilla.commsplantilla.repository.CompraRepository;
import com.ms.plantilla.commsplantilla.service.IService.ICompraService;
import com.ms.plantilla.commsplantilla.service.IService.IViajeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class CompraServiceImpl implements ICompraService {

    @Autowired
    private CompraRepository compraRepository;

    @Autowired
    private AsientoViajeRepository asientoViajeRepository;

    @Autowired
    private IViajeService viajeService;

    @Override
    @Transactional
    public CompraResponseDto realizarCompra(CompraBoletoRequestDto compraDto) {
        // Validar que la cantidad de asientos coincida con la cantidad de pasajeros
        if (compraDto.getAsientosViajeIds().size() != compraDto.getPasajeros().size()) {
            throw new HandlerRequestException400(
                    "400",
                    "Error en la compra",
                    "La cantidad de asientos no coincide con la cantidad de pasajeros",
                    List.of("Debe haber un pasajero por cada asiento seleccionado")
            );
        }

        // Validar y obtener asientos
        List<AsientoViajeModel> asientos = validarAsientosDisponibles(compraDto.getAsientosViajeIds());

        // Crear la compra
        CompraModel compra = new CompraModel();
        compra.setFechaCompra(LocalDateTime.now());
        compra.setReferencia(generarReferencia());
        compra.setEstado(EstadoCompra.PENDIENTE);
        compra.setMetodoPago(MetodoPago.valueOf(compraDto.getMetodoPago()));
        compra.setTotalMonto(calcularTotal(asientos));

        compra = compraRepository.save(compra);

        // Actualizar estado de asientos
        asientos.forEach(asiento -> {
            asiento.setEstado(EstadoAsiento.RESERVADO);
            asientoViajeRepository.save(asiento);
        });

        return mapearCompraResponse(compra, asientos);
    }

    private List<AsientoViajeModel> validarAsientosDisponibles(List<Long> asientosIds) {
        List<AsientoViajeModel> asientos = asientoViajeRepository.findAllById(asientosIds);

        if (asientos.size() != asientosIds.size()) {
            throw new HandlerRequestException404(
                    "404",
                    "Asientos no encontrados",
                    "Algunos asientos seleccionados no existen",
                    List.of("Verifique los IDs de los asientos seleccionados")
            );
        }

        asientos.forEach(asiento -> {
            if (asiento.getEstado() != EstadoAsiento.DISPONIBLE) {
                throw new HandlerRequestException400(
                        "400",
                        "Asiento no disponible",
                        "El asiento " + asiento.getAsiento().getNumeroAsiento() + " no está disponible",
                        List.of("Seleccione solo asientos disponibles")
                );
            }
        });

        return asientos;
    }

    private String generarReferencia() {
        String referencia;
        do {
            referencia = UUID.randomUUID().toString().substring(0, 8).toUpperCase();
        } while (compraRepository.existsByReferencia(referencia));
        return referencia;
    }

    private BigDecimal calcularTotal(List<AsientoViajeModel> asientos) {
        // Aquí iría la lógica para calcular el total según las tarifas
        return BigDecimal.valueOf(100.00 * asientos.size()); // Ejemplo simplificado
    }

    private CompraResponseDto mapearCompraResponse(CompraModel compra, List<AsientoViajeModel> asientos) {
        return CompraResponseDto.builder()
                .referencia(compra.getReferencia())
                .fechaCompra(compra.getFechaCompra())
                .estado(compra.getEstado().toString())
                .metodoPago(compra.getMetodoPago().toString())
                .totalMonto(compra.getTotalMonto())
                .build();
    }

    private void validarViaje(ViajeModel viaje) {
        if (!viaje.getEstado().equals(EstadoViaje.PROGRAMADO)) {
            throw new HandlerRequestException400(
                    "400",
                    "Viaje no disponible",
                    "El viaje no está disponible para compra",
                    List.of("Solo se pueden comprar boletos para viajes programados")
            );
        }

        LocalDateTime ahora = LocalDateTime.now();
        if (viaje.getFechaSalida().isBefore(ahora)) {
            throw new HandlerRequestException400(
                    "400",
                    "Viaje no disponible",
                    "La fecha del viaje ya pasó",
                    List.of("No se pueden comprar boletos para viajes pasados")
            );
        }
    }

    private void validarLimiteAsientos(List<Long> asientosIds) {
        if (asientosIds.size() > 5) {
            throw new HandlerRequestException400(
                    "400",
                    "Límite excedido",
                    "No se pueden comprar más de 5 asientos por transacción",
                    List.of("Seleccione máximo 5 asientos")
            );
        }
    }
}