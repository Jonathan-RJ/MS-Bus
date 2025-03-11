package com.ms.plantilla.commsplantilla.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.sql.Time;
import java.util.List;

@Data
@Entity
@Table(name = "rutas")
@NoArgsConstructor
@AllArgsConstructor
public class RutaModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ruta_id")
    private Long rutaId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "origen_terminal_id")
    private TerminalModel origenTerminal;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "destino_terminal_id")
    private TerminalModel destinoTerminal;

    @Column(name = "duracion_estimada")
    private Time duracionEstimada;

    @Column(name = "orden_secuencia")
    private Integer ordenSecuencia;

    @Column(name = "estado_activo")
    private Boolean estadoActivo = true;

    @OneToMany(mappedBy = "ruta")
    private List<TarifaModel> tarifas;
}
