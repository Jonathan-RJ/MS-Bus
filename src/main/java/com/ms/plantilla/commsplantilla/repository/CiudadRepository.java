package com.ms.plantilla.commsplantilla.repository;

import com.ms.plantilla.commsplantilla.model.CiudadModel;
import jakarta.persistence.Tuple;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface CiudadRepository extends JpaRepository<CiudadModel, Long> {

    @Query("SELECT c.ciudadId AS ciudadId, c.nombre AS ciudad, e.estadoId AS estadoId, " +
            "e.nombre AS estado, e.zonaHoraria AS zonaHoraria " +
            "FROM CiudadModel c JOIN c.estado e")
    List<Tuple> obtenerCiudadesConEstadosTuple();

    List<CiudadModel> findByEstadoEstadoId(Long estadoId);
}
