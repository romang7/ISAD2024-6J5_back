package com.example.demo.Repository;

import com.example.demo.Entity.Orden_Servicio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Orden_ServicioRepository extends JpaRepository<Orden_Servicio, Integer> {
}