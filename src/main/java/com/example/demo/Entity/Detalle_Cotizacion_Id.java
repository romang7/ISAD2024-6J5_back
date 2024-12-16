package com.example.demo.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class Detalle_Cotizacion_Id implements Serializable {

    @Column(name = "CO_ID")
    private Integer cotizacionId;

    @Column(name = "DF_CLAVE")
    private Integer clave;

    // Getters, setters, hashCode y equals
    public Integer getCotizacionId() {
        return cotizacionId;
    }

    public void setCotizacionId(Integer cotizacionId) {
        this.cotizacionId = cotizacionId;
    }

    public Integer getClave() {
        return clave;
    }

    public void setClave(Integer clave) {
        this.clave = clave;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Detalle_Cotizacion_Id that = (Detalle_Cotizacion_Id) o;
        return Objects.equals(cotizacionId, that.cotizacionId) &&
                Objects.equals(clave, that.clave);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cotizacionId, clave);
    }
}