package com.example.demo.Service;

import com.example.demo.Entity.Detalle_Cotizacion;
import com.example.demo.Entity.Detalle_Cotizacion_Id;
import com.example.demo.Repository.Detalle_CotizacionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class Detalle_CotizacionService {

    @Autowired
    private Detalle_CotizacionRepository detalle_CotizacionRepository;

    public List<Detalle_Cotizacion> getDetalle_Cotizacion() {
        return detalle_CotizacionRepository.findAll();
    }

    public Optional<Detalle_Cotizacion> getDetalle_Cotizacion(Detalle_Cotizacion_Id id) {
        return detalle_CotizacionRepository.findById(id);
    }

    public void save(Detalle_Cotizacion detalle_Cotizacion) {
        detalle_CotizacionRepository.save(detalle_Cotizacion);
    }

    public void update(Detalle_Cotizacion detalle_Cotizacion) {
        detalle_CotizacionRepository.save(detalle_Cotizacion);
    }

    public void delete(Detalle_Cotizacion_Id id) {
        detalle_CotizacionRepository.deleteById(id);
    }
}