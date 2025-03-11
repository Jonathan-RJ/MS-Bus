package com.ms.plantilla.commsplantilla.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

@Data
@Entity
@Table(name = "estados")
@NoArgsConstructor
@AllArgsConstructor

public class EstadoModel implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "estado_id")
    private Long estadoId;

    @Column(name = "nombre", nullable = false, unique = true, length = 100)
    private String nombre;

    @Column(name = "zona_horaria", nullable = false, length = 50)
    private String zonaHoraria;

    @OneToMany(mappedBy = "estado")
    private List<CiudadModel> ciudades;

}