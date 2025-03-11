package com.ms.plantilla.commsplantilla.service.IService;

import com.ms.plantilla.commsplantilla.dto.request.CiudadRequestDto;
import com.ms.plantilla.commsplantilla.handler.response.ResponseOk;
import com.ms.plantilla.commsplantilla.model.CiudadModel;
import java.util.List;

public interface ICiudadService {
    ResponseOk obtenerCiudades();
}