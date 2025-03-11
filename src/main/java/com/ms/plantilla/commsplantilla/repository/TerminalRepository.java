package com.ms.plantilla.commsplantilla.repository;

import com.ms.plantilla.commsplantilla.dto.response.TerminalCompletoDTO;
import com.ms.plantilla.commsplantilla.model.TerminalModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TerminalRepository extends JpaRepository<TerminalModel, Long> {



}