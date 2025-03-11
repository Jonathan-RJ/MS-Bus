package com.ms.plantilla.commsplantilla.service;

import com.ms.plantilla.commsplantilla.dto.request.TerminalRequestDto;
import com.ms.plantilla.commsplantilla.dto.response.TerminalCompletoDTO;
import com.ms.plantilla.commsplantilla.handler.exceptions.collections.HandlerRequestException404;
import com.ms.plantilla.commsplantilla.handler.response.ResponseOk;
import com.ms.plantilla.commsplantilla.model.CiudadModel;
import com.ms.plantilla.commsplantilla.model.TerminalModel;
import com.ms.plantilla.commsplantilla.repository.TerminalRepository;
import com.ms.plantilla.commsplantilla.service.IService.ICiudadService;
import com.ms.plantilla.commsplantilla.service.IService.ITerminalService;
import org.slf4j.MDC;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class TerminalServiceImpl implements ITerminalService {

    @Autowired
    private TerminalRepository terminalRepository;

    @Autowired
    private ICiudadService ciudadService;

    @Override
    @Transactional(readOnly = true)
    public ResponseOk obtenerTodasLasTerminales() {
        List<TerminalModel> listaTerminal = terminalRepository.findAll();
        List<TerminalCompletoDTO> listaTerminalCompletoDto = new ArrayList<>();

        for (TerminalModel terminal : listaTerminal) {
            TerminalCompletoDTO terminalCompletoDTO = TerminalCompletoDTO.builder()
                    .id(terminal.getTerminalId())
                    .descripcion(terminal.getNombre())
                    .build();
            listaTerminalCompletoDto.add(terminalCompletoDTO);
        }

        return new ResponseOk("Success", MDC.get("traceId"), listaTerminalCompletoDto);
    }

}