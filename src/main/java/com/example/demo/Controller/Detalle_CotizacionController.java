package com.example.demo.Controller;

import com.example.demo.Entity.Detalle_Cotizacion;
import com.example.demo.Entity.Detalle_Cotizacion_Id;
import com.example.demo.Service.Detalle_CotizacionService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/detalle-cotizacion")
@RequiredArgsConstructor
public class Detalle_CotizacionController {

    private final Detalle_CotizacionService detalle_CotizacionService;

    @GetMapping
    public List<Detalle_Cotizacion> getAll() {
        return detalle_CotizacionService.getDetalle_Cotizacion();
    }

    @GetMapping("/{cotizacionId}/{clave}")
    public Optional<Detalle_Cotizacion> getById(
            @PathVariable("cotizacionId") Integer cotizacionId,
            @PathVariable("clave") Integer clave) {
        Detalle_Cotizacion_Id id = new Detalle_Cotizacion_Id();
        id.setCotizacionId(cotizacionId);
        id.setClave(clave);
        return detalle_CotizacionService.getDetalle_Cotizacion(id);
    }

    @PostMapping()
    public Detalle_Cotizacion save(@RequestBody Detalle_Cotizacion detalle_Cotizacion) {
        detalle_CotizacionService.save(detalle_Cotizacion);
        return detalle_Cotizacion;
    }

    @PatchMapping("/{cotizacionId}/{clave}")
    public Detalle_Cotizacion update(@RequestBody Detalle_Cotizacion detalle_Cotizacion) {
        detalle_CotizacionService.update(detalle_Cotizacion);
        return detalle_Cotizacion;
    }

    @DeleteMapping("/{cotizacionId}/{clave}")
    public void delete(
            @PathVariable("cotizacionId") Integer cotizacionId,
            @PathVariable("clave") Integer clave) {
        Detalle_Cotizacion_Id id = new Detalle_Cotizacion_Id();
        id.setCotizacionId(cotizacionId);
        id.setClave(clave);
        detalle_CotizacionService.delete(id);
    }
}