package com.ms.plantilla.commsplantilla.model;

import com.ms.plantilla.commsplantilla.model.enums.ClaseServicio;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "tipos_autobus")
@NoArgsConstructor
@AllArgsConstructor
public class TipoAutobusModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "tipo_id")
    private Long tipoId;

    @Column(name = "nombre", nullable = false)
    private String nombre;

    @Column(name = "descripcion")
    private String descripcion;

    @Column(name = "num_asientos", nullable = false)
    private Integer numAsientos;

    @Column(name = "caracteristicas", columnDefinition = "json")
    private String caracteristicas;

    @Enumerated(EnumType.STRING)
    @Column(name = "clase_servicio")
    private ClaseServicio claseServicio;
}