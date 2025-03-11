package com.ms.plantilla.commsplantilla.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "autobuses")
@NoArgsConstructor
@AllArgsConstructor
public class AutobusModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "autobus_id")
    private Long autobusId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "tipo_id")
    private TipoAutobusModel tipo;

    @Column(name = "numero_unidad", unique = true)
    private String numeroUnidad;

    @Column(name = "placa", unique = true)
    private String placa;

    @Column(name = "año_modelo")
    private Integer añoModelo;

    @Column(name = "estado_operativo")
    private Boolean estadoOperativo = true;
}
