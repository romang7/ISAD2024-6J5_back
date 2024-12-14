package com.example.demo.Controller;

import com.example.demo.Entity.Detalle_Material;
import com.example.demo.Entity.Detalle_Material_Id;
import com.example.demo.Service.Detalle_MaterialService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/detalle-material")
@RequiredArgsConstructor
public class Detalle_MaterialController {

    private final Detalle_MaterialService detalle_MaterialService;

    @GetMapping
    public List<Detalle_Material> getAll() {
        return detalle_MaterialService.getDetalle_Material();
    }

    @GetMapping("/{ordenServicioId}/{materialId}")
    public Optional<Detalle_Material> getById(
            @PathVariable("ordenServicioId") Integer ordenServicioId,
            @PathVariable("materialId") Integer materialId) {
        Detalle_Material_Id id = new Detalle_Material_Id();
        id.setOrdenServicioId(ordenServicioId);
        id.setMaterialId(materialId);
        return detalle_MaterialService.getDetalle_Material(id);
    }

    @PostMapping()
    public Detalle_Material save(@RequestBody Detalle_Material detalle_Material) {
        detalle_MaterialService.save(detalle_Material);
        return detalle_Material;
    }

    @PatchMapping("/{ordenServicioId}/{materialId}")
    public Detalle_Material update(@RequestBody Detalle_Material detalle_Material) {
        detalle_MaterialService.update(detalle_Material);
        return detalle_Material;
    }

    @DeleteMapping("/{ordenServicioId}/{materialId}")
    public void delete(
            @PathVariable("ordenServicioId") Integer ordenServicioId,
            @PathVariable("materialId") Integer materialId) {
        Detalle_Material_Id id = new Detalle_Material_Id();
        id.setOrdenServicioId(ordenServicioId);
        id.setMaterialId(materialId);
        detalle_MaterialService.delete(id);
    }
}