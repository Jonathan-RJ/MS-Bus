package com.ms.plantilla.commsplantilla.repository;

import com.ms.plantilla.commsplantilla.dto.response.AsientoDisponibleDto;
import com.ms.plantilla.commsplantilla.model.AsientoViajeModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AsientoViajeRepository extends JpaRepository<AsientoViajeModel, Long> {

    @Query("""
        SELECT new com.ms.plantilla.commsplantilla.dto.response.AsientoDisponibleDto(
            av.asientoViajeId,
            a.numeroAsiento,
            CAST(a.tipoAsiento as string),
            COALESCE(t.precioBase, 0),
            CAST(av.estado as string))
        FROM AsientoViajeModel av
        JOIN av.asiento a
        JOIN av.viaje v
        JOIN v.ruta r
        LEFT JOIN r.tarifas t
        WHERE v.viajeId = :viajeId
        AND av.estado = com.ms.plantilla.commsplantilla.model.enums.EstadoAsiento.DISPONIBLE
        ORDER BY a.numeroAsiento
    """)
    List<AsientoDisponibleDto> findAsientosDisponiblesByViajeId(@Param("viajeId") Long viajeId);
}