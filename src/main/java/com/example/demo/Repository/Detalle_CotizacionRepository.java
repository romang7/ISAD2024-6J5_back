package com.example.demo.Repository;

import com.example.demo.Entity.Detalle_Cotizacion;
import com.example.demo.Entity.Detalle_Cotizacion_Id;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Detalle_CotizacionRepository extends JpaRepository<Detalle_Cotizacion, Detalle_Cotizacion_Id> {
}