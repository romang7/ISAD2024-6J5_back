package com.example.demo.Repository;

import com.example.demo.Entity.Detalle_Material;
import com.example.demo.Entity.Detalle_Material_Id;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Detalle_MaterialRepository extends JpaRepository<Detalle_Material, Detalle_Material_Id> {
}