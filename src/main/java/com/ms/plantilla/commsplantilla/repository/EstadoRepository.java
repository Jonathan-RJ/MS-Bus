package com.ms.plantilla.commsplantilla.repository;

import com.ms.plantilla.commsplantilla.model.EstadoModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EstadoRepository extends JpaRepository<EstadoModel, Long> {
    boolean existsByNombre(String nombre);
}