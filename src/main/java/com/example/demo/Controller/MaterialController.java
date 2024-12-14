package com.example.demo.Controller;

import com.example.demo.Entity.Material;
import com.example.demo.Service.MaterialService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/material")
@RequiredArgsConstructor
public class MaterialController {

    private final MaterialService materialService;

    @GetMapping
    public List<Material> getAll() {
        return materialService.getMaterial();
    }

    @GetMapping("/{id}")
    public Optional<Material> getById(@PathVariable("id") Integer id) {
        return materialService.getMaterial(id);
    }

    @PostMapping()
    public Material save(@RequestBody Material material) {
        materialService.save(material);
        return material;
    }

    @PatchMapping("/{id}")
    public Material update(@RequestBody Material material) {
        materialService.update(material);
        return material;
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Integer id) {
        materialService.delete(id);
    }
}