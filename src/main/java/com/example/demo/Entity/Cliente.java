package com.example.demo.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column()
    private Integer id;

    @Column(unique = true, nullable = false, length = 13)
    private String rfc;

    @Column(nullable = false, length = 100)
    private String razonSocial;

    @Column(nullable = false, length = 100)
    private String nombre;

    @Column(nullable = false, length = 150)
    private String domicilio;

    @Column(nullable = false, length = 10)
    private String codigoPostal;

    @Column(unique = true, nullable = false, length = 50)
    private String correo;

    @Column(unique = true, nullable = false, length = 20)
    private String telefono;

    @Column(unique = true, nullable = false, length = 50)
    private String empresa;

    @Column(nullable = false, length = 50)
    private String colonia;

    @Column(nullable = false, length = 50)
    private String ciudad;

    @Column(name = "Cl_Municipio", nullable = true, length = 50)
    private String municipio;

    @Column(nullable = false, length = 50)
    private String estado;

    @Column(name = "Cl_Pais", nullable = true, length = 50)
    private String pais;

    private java.sql.Date fechaRegistro;

}
