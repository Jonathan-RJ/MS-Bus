package com.ms.plantilla.commsplantilla.repository;

import com.ms.plantilla.commsplantilla.model.AutobusModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AutobusRepository extends JpaRepository<AutobusModel, Long> {
    // Métodos específicos si los necesitamos
}