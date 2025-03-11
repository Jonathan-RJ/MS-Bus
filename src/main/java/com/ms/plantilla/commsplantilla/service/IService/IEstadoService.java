package com.ms.plantilla.commsplantilla.service.IService;

import com.ms.plantilla.commsplantilla.dto.request.EstadoRequestDto;
import com.ms.plantilla.commsplantilla.model.EstadoModel;
import java.util.List;

public interface IEstadoService {
    List<EstadoModel> obtenerEstados();

}