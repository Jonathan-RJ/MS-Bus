package com.ms.plantilla.commsplantilla.service.IService;

import com.ms.plantilla.commsplantilla.dto.request.TerminalRequestDto;
import com.ms.plantilla.commsplantilla.dto.response.TerminalCompletoDTO;
import com.ms.plantilla.commsplantilla.handler.response.ResponseOk;
import com.ms.plantilla.commsplantilla.model.TerminalModel;
import java.util.List;

public interface ITerminalService {
    ResponseOk obtenerTodasLasTerminales();
}