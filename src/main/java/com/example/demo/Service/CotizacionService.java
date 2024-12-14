package com.example.demo.Service;

import com.example.demo.Entity.Cotizacion;
import com.example.demo.Repository.CotizacionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CotizacionService {

    @Autowired
    CotizacionRepository cotizacionRepository;

    public List<Cotizacion> getCotizacion() {
        return cotizacionRepository.findAll();
    }

    public Optional<Cotizacion> getCotizacion(Integer id) {
        return cotizacionRepository.findById(id);
    }

    public void save(Cotizacion cotizacion) {
        cotizacionRepository.save(cotizacion);
    }

    public void update(Cotizacion cotizacion) {
        cotizacionRepository.save(cotizacion);
    }

    public void delete(Integer id) {
        cotizacionRepository.deleteById(id);
    }
}