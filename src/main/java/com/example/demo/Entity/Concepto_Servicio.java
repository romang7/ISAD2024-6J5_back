package com.example.demo.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Concepto_Servicio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CS_ID")
    private Integer id;

    @Column(name = "CS_NOMBRE", nullable = false, length = 50)
    private String nombre;

    @Column(name = "CS_Descripcion", length = 100)
    private String descripcion;

    @Column(name = "CS_Tarifa", nullable = false, precision = 10, scale = 2)
    private BigDecimal tarifa;
}