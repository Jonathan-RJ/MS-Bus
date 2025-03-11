package com.ms.plantilla.commsplantilla.model;

import com.ms.plantilla.commsplantilla.model.enums.TipoAsiento;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "asientos")
@NoArgsConstructor
@AllArgsConstructor
public class AsientoModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "asiento_id")
    private Long asientoId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "autobus_id")
    private AutobusModel autobus;

    @Column(name = "numero_asiento")
    private String numeroAsiento;

    @Enumerated(EnumType.STRING)
    @Column(name = "tipo_asiento")
    private TipoAsiento tipoAsiento;

    @Column(name = "estado_operativo")
    private Boolean estadoOperativo = true;
}