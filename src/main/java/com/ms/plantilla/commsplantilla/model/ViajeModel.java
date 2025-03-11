package com.ms.plantilla.commsplantilla.model;

import com.ms.plantilla.commsplantilla.model.enums.EstadoViaje;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "viajes")
@NoArgsConstructor
@AllArgsConstructor
public class ViajeModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "viaje_id")
    private Long viajeId;

    @Column(name = "folio", unique = true)
    private String folio;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ruta_id")
    private RutaModel ruta;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "autobus_id")
    private AutobusModel autobus;

    @Column(name = "fecha_salida")
    private LocalDateTime fechaSalida;

    @Column(name = "fecha_llegada")
    private LocalDateTime fechaLlegada;

    @Enumerated(EnumType.STRING)
    @Column(name = "estado")
    private EstadoViaje estado;
}
