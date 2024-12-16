package com.example.demo.Controller;

import com.example.demo.Entity.Concepto_Servicio;
import com.example.demo.Service.Concepto_ServicioService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/concepto-servicio")
@RequiredArgsConstructor
public class Concepto_ServicioController {

    private final Concepto_ServicioService concepto_ServicioService;

    @GetMapping
    public List<Concepto_Servicio> getAll() {
        return concepto_ServicioService.getConcepto_Servicio();
    }

    @GetMapping("/{id}")
    public Optional<Concepto_Servicio> getById(@PathVariable("id") Integer id) {
        return concepto_ServicioService.getConcepto_Servicio(id);
    }

    @PostMapping()
    public Concepto_Servicio save(@RequestBody Concepto_Servicio concepto_Servicio) {
        concepto_ServicioService.save(concepto_Servicio);
        return concepto_Servicio;
    }

    @PatchMapping("/{id}")
    public Concepto_Servicio update(@RequestBody Concepto_Servicio concepto_Servicio) {
        concepto_ServicioService.update(concepto_Servicio);
        return concepto_Servicio;
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Integer id) {
        concepto_ServicioService.delete(id);
    }
}