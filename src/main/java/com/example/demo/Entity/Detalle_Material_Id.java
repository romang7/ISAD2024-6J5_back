package com.example.demo.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class Detalle_Material_Id implements Serializable {

    @Column(name = "OS_CLAVE")
    private Integer ordenServicioId;

    @Column(name = "MA_ID")
    private Integer materialId;

    // Getters, setters, equals y hashCode
    public Integer getOrdenServicioId() {
        return ordenServicioId;
    }

    public void setOrdenServicioId(Integer ordenServicioId) {
        this.ordenServicioId = ordenServicioId;
    }

    public Integer getMaterialId() {
        return materialId;
    }

    public void setMaterialId(Integer materialId) {
        this.materialId = materialId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Detalle_Material_Id that = (Detalle_Material_Id) o;
        return Objects.equals(ordenServicioId, that.ordenServicioId) &&
                Objects.equals(materialId, that.materialId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ordenServicioId, materialId);
    }
}