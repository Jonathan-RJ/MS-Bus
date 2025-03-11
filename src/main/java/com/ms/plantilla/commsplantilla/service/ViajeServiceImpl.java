package com.ms.plantilla.commsplantilla.service;

import com.ms.plantilla.commsplantilla.dto.request.BusquedaViajeRequestDto;
import com.ms.plantilla.commsplantilla.dto.request.ViajeRequestDto;
import com.ms.plantilla.commsplantilla.dto.response.AsientoDisponibleDto;
import com.ms.plantilla.commsplantilla.dto.response.ViajeResponseDto;
import com.ms.plantilla.commsplantilla.handler.exceptions.collections.HandlerRequestException400;
import com.ms.plantilla.commsplantilla.handler.exceptions.collections.HandlerRequestException404;
import com.ms.plantilla.commsplantilla.model.ViajeModel;
import com.ms.plantilla.commsplantilla.model.enums.EstadoViaje;
import com.ms.plantilla.commsplantilla.repository.AsientoViajeRepository;
import com.ms.plantilla.commsplantilla.repository.ViajeRepository;
import com.ms.plantilla.commsplantilla.service.IService.ITerminalService;
import com.ms.plantilla.commsplantilla.service.IService.IViajeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;

@Service
public class ViajeServiceImpl implements IViajeService {

    @Autowired
    private ViajeRepository viajeRepository;

    @Autowired
    private AsientoViajeRepository asientoViajeRepository;

    @Autowired
    private ITerminalService terminalService;

    @Override
    public ViajeResponseDto crearViaje(ViajeRequestDto viajeDto) {
        return null;
    }

    @Override
    public List<ViajeResponseDto> obtenerViajesProgramados() {
        return null;
    }

    @Override
    public ViajeResponseDto actualizarEstadoViaje(Long viajeId, EstadoViaje nuevoEstado) {
        return null;
    }

    @Override
    public List<ViajeResponseDto> buscarViajes(BusquedaViajeRequestDto busquedaDto) {
        return null;
    }

    @Override
    public List<AsientoDisponibleDto> obtenerAsientosDisponibles(Long viajeId) {
        return null;
    }

}