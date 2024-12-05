package com.example.demo.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Producto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "PR_NOMBRE", nullable = false, length = 50)
    private String nombre;

    @Column(name = "PR_MARCA", nullable = false, length = 50)
    private String marca;

    @Column(name = "PR_MODELO", nullable = false, length = 50)
    private String modelo;

    @Column(name = "PR_DESCRIPCION", length = 100)
    private String descripcion;

    @Column(name = "PR_CANTIDAD")
    private Integer cantidad;

    @Column(name = "PR_PRECIO", precision = 10)
    private Double precio;

}
