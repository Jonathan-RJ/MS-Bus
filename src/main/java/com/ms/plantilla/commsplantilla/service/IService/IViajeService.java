package com.ms.plantilla.commsplantilla.service.IService;

import com.ms.plantilla.commsplantilla.dto.request.BusquedaViajeRequestDto;
import com.ms.plantilla.commsplantilla.dto.request.ViajeRequestDto;
import com.ms.plantilla.commsplantilla.dto.response.AsientoDisponibleDto;
import com.ms.plantilla.commsplantilla.dto.response.ViajeResponseDto;
import com.ms.plantilla.commsplantilla.model.enums.EstadoViaje;

import java.util.List;

public interface IViajeService {
    ViajeResponseDto crearViaje(ViajeRequestDto viajeDto);
    List<ViajeResponseDto> obtenerViajesProgramados();
    ViajeResponseDto actualizarEstadoViaje(Long viajeId, EstadoViaje nuevoEstado);

    List<ViajeResponseDto> buscarViajes(BusquedaViajeRequestDto busquedaDto);

    List<AsientoDisponibleDto> obtenerAsientosDisponibles(Long viajeId);
}