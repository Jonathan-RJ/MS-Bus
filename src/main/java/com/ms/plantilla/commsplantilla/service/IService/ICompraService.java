package com.ms.plantilla.commsplantilla.service.IService;

import com.ms.plantilla.commsplantilla.dto.request.CompraBoletoRequestDto;
import com.ms.plantilla.commsplantilla.dto.response.CompraResponseDto;

public interface ICompraService {
    CompraResponseDto realizarCompra(CompraBoletoRequestDto compraDto);
}
