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
    private Integer id;

    @Column(name = "Cl_RFC", unique = true, nullable = false, length = 13)
    private String rfc;

    @Column(name = "Cl_RazonSocial", nullable = false, length = 100)
    private String razonSocial;

    @Column(name = "Cl_Nombre", nullable = false, length = 50)
    private String nombre;

    @Column(name = "Cl_ApPaterno", nullable = false, length = 50)
    private String appaterno;

    @Column(name = "Cl_ApMaterno", nullable = false, length = 50)
    private String apmaterno;

    @Column(name = "Cl_Domicilio", nullable = false, length = 150)
    private String domicilio;

    @Column(name = "Cl_CodigoPostal", nullable = false, length = 10)
    private String codigoPostal;

    @Column(name = "Cl_Correo", unique = true, nullable = false, length = 50)
    private String correo;

    @Column(name = "Cl_Telefono", unique = true, nullable = false, length = 20)
    private String telefono;

    @Column(name = "Cl_Empresa", unique = true, nullable = false, length = 50)
    private String empresa;

    @Column(name = "Cl_Colonia", nullable = false, length = 50)
    private String colonia;

    @Column(name = "Cl_Ciudad", nullable = false, length = 50)
    private String ciudad;

    /*@Column(name = "Cl_Municipio", nullable = false, length = 50)
    private String municipio;*/

    @Column(name = "Cl_Estado", nullable = false, length = 50)
    private String estado;

    /*@Column(name = "Cl_Pais", nullable = false, length = 50)
    private String pais;*/

    @Column(name = "CL_FECHA_REGISTRO")
    private java.sql.Date fechaRegistro;


}
