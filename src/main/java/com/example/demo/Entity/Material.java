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
public class Material {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "MA_ID")
    private Integer id;

    @Column(name = "MA_NOMBRE", nullable = false, length = 50)
    private String nombre;

    @Column(name = "MA_MARCA", nullable = false, length = 50)
    private String marca;

    @Column(name = "MA_DESCRIPCION", length = 100)
    private String descripcion;

    @Column(name = "MA_COSTO", nullable = false, precision = 10, scale = 2)
    private BigDecimal costo;

    @Column(name = "MA_STOCK", nullable = false)
    private Integer stock;
}