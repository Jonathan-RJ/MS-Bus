package com.ms.plantilla.commsplantilla.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.math.BigDecimal;

@Data
@Entity
@Table(name = "tipos_persona")
@NoArgsConstructor
@AllArgsConstructor
public class TipoPersonaModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "tipo_persona_id")
    private Long tipoPersonaId;

    @Column(name = "nombre", nullable = false)
    private String nombre;

    @Column(name = "descripcion")
    private String descripcion;

    @Column(name = "descuento")
    private BigDecimal descuento;
}