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
@Table(name = "CUENTA")
public class Cuenta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Cu_ID")
    private Integer id; // Cambiado a Integer para coincidir con INT en MySQL

    @Column(name = "Cu_Nombre", nullable = false, length = 50)
    private String nombre;

    @Column(name = "Cu_NumCuenta", length = 4)
    private String numCuenta;

    @Column(name = "Cu_Direccion", nullable = false, length = 50)
    private String direccion;

    @Column(name = "Cu_Referencia", length = 50)
    private String referencia;

    @Column(name = "Cu_Telefono", unique = true, length = 10)
    private String telefono;

    @Column(name = "Cu_SaldoFavor", precision = 10, columnDefinition = "DECIMAL(10,2) DEFAULT 0")
    private Double saldoFavor;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "Cl_ID", nullable = false)
    private Cliente cliente;
}