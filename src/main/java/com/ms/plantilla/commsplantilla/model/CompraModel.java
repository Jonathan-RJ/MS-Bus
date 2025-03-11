package com.ms.plantilla.commsplantilla.model;

import com.ms.plantilla.commsplantilla.model.enums.EstadoCompra;
import com.ms.plantilla.commsplantilla.model.enums.MetodoPago;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "compras")
@NoArgsConstructor
@AllArgsConstructor
public class CompraModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "compra_id")
    private Long compraId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "usuario_id")
    private UsuarioModel usuario;

    @Column(name = "fecha_compra")
    private LocalDateTime fechaCompra;

    @Column(name = "referencia", unique = true)
    private String referencia;

    @Enumerated(EnumType.STRING)
    @Column(name = "estado")
    private EstadoCompra estado;

    @Enumerated(EnumType.STRING)
    @Column(name = "metodo_pago")
    private MetodoPago metodoPago;

    @Column(name = "total_monto")
    private BigDecimal totalMonto;
}