package com.ms.plantilla.commsplantilla.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Entity
@Table(name = "tarifas")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TarifaModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "tarifa_id")
    private Long tarifaId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ruta_id")
    private RutaModel ruta;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "tipo_autobus_id")
    private TipoAutobusModel tipoAutobus;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "tipo_persona_id")
    private TipoPersonaModel tipoPersona;

    @Column(name = "precio_base")
    private BigDecimal precioBase;
}
