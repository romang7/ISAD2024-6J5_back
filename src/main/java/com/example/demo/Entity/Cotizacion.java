package com.example.demo.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;
import java.sql.Time;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Cotizacion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CO_ID")
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "CU_ID", nullable = false)
    private Cuenta cuenta;

    @Column(name = "CO_FECHA")
    private Date fecha;

    @Column(name = "CO_HORA")
    private Time hora;
}