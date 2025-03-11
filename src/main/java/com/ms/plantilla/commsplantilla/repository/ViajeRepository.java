package com.ms.plantilla.commsplantilla.repository;

import com.ms.plantilla.commsplantilla.dto.response.ViajeResponseDto;
import com.ms.plantilla.commsplantilla.model.ViajeModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.time.LocalDate;
import java.util.List;

@Repository
public interface ViajeRepository extends JpaRepository<ViajeModel, Long> {

    @Query("""
        SELECT new com.ms.plantilla.commsplantilla.dto.response.ViajeResponseDto(
            v.folio,
            o.nombre,
            d.nombre,
            v.fechaSalida,
            v.fechaLlegada,
            CAST(v.estado as string),
            a.numeroUnidad)
        FROM ViajeModel v
        JOIN v.ruta r
        JOIN r.origenTerminal o
        JOIN r.destinoTerminal d
        JOIN v.autobus a
        WHERE DATE(v.fechaSalida) = :fecha
        AND o.terminalId = :origenId
        AND d.terminalId = :destinoId
        AND v.estado = com.ms.plantilla.commsplantilla.model.enums.EstadoViaje.PROGRAMADO
        ORDER BY v.fechaSalida
    """)
    List<ViajeResponseDto> buscarViajes(
            @Param("fecha") LocalDate fecha,
            @Param("origenId") Long origenId,
            @Param("destinoId") Long destinoId
    );
}