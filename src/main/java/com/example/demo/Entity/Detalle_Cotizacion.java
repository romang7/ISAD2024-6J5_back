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
public class Detalle_Cotizacion {

    @EmbeddedId
    private Detalle_Cotizacion_Id id;

    @Column(name = "DF_TIPO")
    private Boolean tipo;

    @Column(name = "DF_CANTIDAD", nullable = false)
    private Integer cantidad;

    @Column(name = "DF_PRECIO_V", precision = 10, scale = 2)
    private BigDecimal precioVenta;

    @ManyToOne
    @MapsId("cotizacionId") // Vincula con el campo cotizacionId en la clave compuesta
    @JoinColumn(name = "CO_ID", nullable = false)
    private Cotizacion cotizacion;
}