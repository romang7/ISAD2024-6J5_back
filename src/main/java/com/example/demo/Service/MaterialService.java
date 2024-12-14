package com.example.demo.Service;

import com.example.demo.Entity.Material;
import com.example.demo.Repository.MaterialRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MaterialService {

    @Autowired
    private MaterialRepository materialRepository;

    public List<Material> getMaterial() {
        return materialRepository.findAll();
    }

    public Optional<Material> getMaterial(Integer id) {
        return materialRepository.findById(id);
    }

    public void save(Material material) {
        materialRepository.save(material);
    }

    public void update(Material material) {
        materialRepository.save(material);
    }

    public void delete(Integer id) {
        materialRepository.deleteById(id);
    }
}