package com.ms.plantilla.commsplantilla.service;

import com.ms.plantilla.commsplantilla.handler.exceptions.collections.HandlerRequestException404;
import com.ms.plantilla.commsplantilla.service.IService.IEstadoService;
import com.ms.plantilla.commsplantilla.repository.EstadoRepository;
import com.ms.plantilla.commsplantilla.model.EstadoModel;
import com.ms.plantilla.commsplantilla.dto.request.EstadoRequestDto;
import com.ms.plantilla.commsplantilla.handler.exceptions.collections.HandlerRequestException404;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service
public class EstadoServiceImpl implements IEstadoService {

    @Autowired
    private EstadoRepository estadoRepository;


    @Override
    @Transactional(readOnly = true)
    public List<EstadoModel> obtenerEstados() {
        return estadoRepository.findAll();
    }

}
