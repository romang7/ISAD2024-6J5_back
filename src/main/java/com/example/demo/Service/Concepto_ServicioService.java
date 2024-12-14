package com.example.demo.Service;

import com.example.demo.Entity.Concepto_Servicio;
import com.example.demo.Repository.Concepto_ServicioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class Concepto_ServicioService {

    @Autowired
    private Concepto_ServicioRepository concepto_ServicioRepository;

    public List<Concepto_Servicio> getConcepto_Servicio() {
        return concepto_ServicioRepository.findAll();
    }

    public Optional<Concepto_Servicio> getConcepto_Servicio(Integer id) {
        return concepto_ServicioRepository.findById(id);
    }

    public void save(Concepto_Servicio concepto_Servicio) {
        concepto_ServicioRepository.save(concepto_Servicio);
    }

    public void update(Concepto_Servicio concepto_Servicio) {
        concepto_ServicioRepository.save(concepto_Servicio);
    }

    public void delete(Integer id) {
        concepto_ServicioRepository.deleteById(id);
    }
}