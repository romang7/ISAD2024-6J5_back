package com.example.demo.Repository;

import com.example.demo.Entity.Concepto_Servicio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Concepto_ServicioRepository extends JpaRepository<Concepto_Servicio, Integer> {
}