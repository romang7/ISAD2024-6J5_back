package com.example.demo.Service;

import com.example.demo.Entity.Orden_Servicio;
import com.example.demo.Repository.Orden_ServicioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class Orden_ServicioService {

    @Autowired
    private Orden_ServicioRepository orden_ServicioRepository;

    public List<Orden_Servicio> getOrden_Servicio() {
        return orden_ServicioRepository.findAll();
    }

    public Optional<Orden_Servicio> getOrden_Servicio(Integer clave) {
        return orden_ServicioRepository.findById(clave);
    }

    public void save(Orden_Servicio orden_Servicio) {
        orden_ServicioRepository.save(orden_Servicio);
    }

    public void update(Orden_Servicio orden_Servicio) {
        orden_ServicioRepository.save(orden_Servicio);
    }

    public void delete(Integer clave) {
        orden_ServicioRepository.deleteById(clave);
    }
}