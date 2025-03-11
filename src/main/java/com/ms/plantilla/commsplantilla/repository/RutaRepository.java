package com.ms.plantilla.commsplantilla.repository;

import com.ms.plantilla.commsplantilla.model.RutaModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RutaRepository extends JpaRepository<RutaModel, Long> {
    // Aquí podemos agregar métodos específicos si los necesitamos
}