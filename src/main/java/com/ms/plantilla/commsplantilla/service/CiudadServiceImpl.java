package com.ms.plantilla.commsplantilla.service;

import com.ms.plantilla.commsplantilla.dto.request.CiudadRequestDto;
import com.ms.plantilla.commsplantilla.dto.response.CiudadResponseDto;
import com.ms.plantilla.commsplantilla.handler.exceptions.collections.HandlerRequestException404;
import com.ms.plantilla.commsplantilla.handler.response.ResponseOk;
import com.ms.plantilla.commsplantilla.model.CiudadModel;
import com.ms.plantilla.commsplantilla.model.EstadoModel;
import com.ms.plantilla.commsplantilla.repository.CiudadRepository;
import com.ms.plantilla.commsplantilla.service.IService.ICiudadService;
import com.ms.plantilla.commsplantilla.service.IService.IEstadoService;
import jakarta.persistence.Tuple;
import org.slf4j.MDC;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class CiudadServiceImpl implements ICiudadService {

    @Autowired
    private CiudadRepository ciudadRepository;


    @Override
    public ResponseOk obtenerCiudades() {

        List<Tuple> resultados = ciudadRepository.obtenerCiudadesConEstadosTuple();
        List<CiudadResponseDto> listaCiudades = new ArrayList<>();

        for (Tuple tuple : resultados) {
            CiudadResponseDto dto = new CiudadResponseDto(
                    tuple.get("ciudadId", Long.class),
                    tuple.get("estado", String.class) + "🫦" + tuple.get("ciudad", String.class)
            );
            listaCiudades.add(dto);
        }

        return new ResponseOk("Succes", MDC.get("traceId"), listaCiudades);

    }


}