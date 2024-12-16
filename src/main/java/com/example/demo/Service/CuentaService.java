package com.example.demo.Service;

import com.example.demo.Entity.Cuenta;
import com.example.demo.Repository.CuentaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CuentaService {

    @Autowired
    CuentaRepository cuentaRepository;

    public List<Cuenta> getCuenta() {
        return cuentaRepository.findAll();
    }

    public Optional<Cuenta> getCuenta(Integer id) {
        return cuentaRepository.findById(id);
    }

    public void save(Cuenta cuenta) {
        cuentaRepository.save(cuenta);
    }

    public void update(Cuenta cuenta) {
        cuentaRepository.save(cuenta);
    }

    public void delete(Integer id) {
        cuentaRepository.deleteById(id);
    }
}