package com.ms.plantilla.commsplantilla.model;

import com.ms.plantilla.commsplantilla.model.enums.EstadoAsiento;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "asientos_viaje")
@NoArgsConstructor
@AllArgsConstructor
public class AsientoViajeModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "asiento_viaje_id")
    private Long asientoViajeId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "viaje_id")
    private ViajeModel viaje;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "autobus_id")
    private AutobusModel autobus;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "asiento_id")
    private AsientoModel asiento;

    @Enumerated(EnumType.STRING)
    @Column(name = "estado")
    private EstadoAsiento estado = EstadoAsiento.DISPONIBLE;
}