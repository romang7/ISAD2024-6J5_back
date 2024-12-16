package com.example.demo.Service;

import com.example.demo.Entity.Detalle_Material;
import com.example.demo.Entity.Detalle_Material_Id;
import com.example.demo.Repository.Detalle_MaterialRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class Detalle_MaterialService {

    @Autowired
    private Detalle_MaterialRepository detalle_MaterialRepository;

    public List<Detalle_Material> getDetalle_Material() {
        return detalle_MaterialRepository.findAll();
    }

    public Optional<Detalle_Material> getDetalle_Material(Detalle_Material_Id id) {
        return detalle_MaterialRepository.findById(id);
    }

    public void save(Detalle_Material detalle_Material) {
        detalle_MaterialRepository.save(detalle_Material);
    }

    public void update(Detalle_Material detalle_Material) {
        detalle_MaterialRepository.save(detalle_Material);
    }

    public void delete(Detalle_Material_Id id) {
        detalle_MaterialRepository.deleteById(id);
    }
}