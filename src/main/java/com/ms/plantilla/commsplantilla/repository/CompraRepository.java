package com.ms.plantilla.commsplantilla.repository;

import com.ms.plantilla.commsplantilla.model.CompraModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CompraRepository extends JpaRepository<CompraModel, Long> {
    boolean existsByReferencia(String referencia);
}
