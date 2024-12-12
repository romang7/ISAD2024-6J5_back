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
public class Orden_Servicio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "OS_CLAVE")
    private Integer clave;

    @ManyToOne
    @JoinColumn(name = "CS_ID", nullable = false)
    private Concepto_Servicio conceptoServicio;

    @Column(name = "OS_DIRECCION", length = 150)
    private String direccion;
}