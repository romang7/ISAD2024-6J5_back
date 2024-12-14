package com.example.demo.Controller;

import com.example.demo.Entity.Orden_Servicio;
import com.example.demo.Service.Orden_ServicioService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/orden-servicio")
@RequiredArgsConstructor
public class Orden_ServicioController {

    private final Orden_ServicioService orden_ServicioService;

    @GetMapping
    public List<Orden_Servicio> getAll() {
        return orden_ServicioService.getOrden_Servicio();
    }

    @GetMapping("/{clave}")
    public Optional<Orden_Servicio> getById(@PathVariable("clave") Integer clave) {
        return orden_ServicioService.getOrden_Servicio(clave);
    }

    @PostMapping()
    public Orden_Servicio save(@RequestBody Orden_Servicio orden_Servicio) {
        orden_ServicioService.save(orden_Servicio);
        return orden_Servicio;
    }

    @PatchMapping("/{clave}")
    public Orden_Servicio update(@RequestBody Orden_Servicio orden_Servicio) {
        orden_ServicioService.update(orden_Servicio);
        return orden_Servicio;
    }

    @DeleteMapping("/{clave}")
    public void delete(@PathVariable("clave") Integer clave) {
        orden_ServicioService.delete(clave);
    }
}