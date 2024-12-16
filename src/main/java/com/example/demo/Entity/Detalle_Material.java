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
public class Detalle_Material {

    @EmbeddedId
    private Detalle_Material_Id id;

    @ManyToOne
    @MapsId("ordenServicioId")
    @JoinColumn(name = "OS_CLAVE", nullable = false)
    private Orden_Servicio ordenServicio;

    @ManyToOne
    @MapsId("materialId")
    @JoinColumn(name = "MA_ID", nullable = false)
    private Material material;

    @Column(name = "OS_PRECIO_V", nullable = false)
    private Integer precioVenta;
}