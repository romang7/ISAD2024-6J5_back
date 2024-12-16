package com.example.demo.Controller;

import com.example.demo.Entity.Cotizacion;
import com.example.demo.Service.CotizacionService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/cotizacion")
@RequiredArgsConstructor
public class CotizacionController {

    private final CotizacionService cotizacionService;

    @GetMapping
    public List<Cotizacion> getAll() {
        return cotizacionService.getCotizacion();
    }

    @GetMapping("/{cotizacionId}")
    public Optional<Cotizacion> getById(@PathVariable("cotizacionId") Integer cotizacionId) {
        return cotizacionService.getCotizacion(cotizacionId);
    }

    @PostMapping()
    public Cotizacion save(@RequestBody Cotizacion cotizacion) {
        cotizacionService.save(cotizacion);
        return cotizacion;

    }

    @PatchMapping("/{cotizacionId}")
    public Cotizacion update(@RequestBody Cotizacion cotizacion) {
        cotizacionService.update(cotizacion);
        return cotizacion;
    }

    @DeleteMapping("/{cotizacionId}")
    public void delete(@PathVariable("cotizacionId") Integer cotizacionId) {
        cotizacionService.delete(cotizacionId);
    }
}