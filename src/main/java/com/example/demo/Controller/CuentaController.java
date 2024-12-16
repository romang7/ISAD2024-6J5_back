package com.example.demo.Controller;

import com.example.demo.Entity.Cuenta;
import com.example.demo.Service.CuentaService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/cuenta")
@RequiredArgsConstructor
public class CuentaController {

    private final CuentaService cuentaService;

    @GetMapping
    public List<Cuenta> getAll() {
        return cuentaService.getCuenta();
    }

    @GetMapping("/{cuentaId}")
    public Optional<Cuenta> getById(@PathVariable("cuentaId") Integer cuentaId) {
        return cuentaService.getCuenta(cuentaId);
    }

    @PostMapping()
    public Cuenta save(@RequestBody Cuenta cuenta) {
        cuentaService.save(cuenta);
        return cuenta;
    }

    @PatchMapping("/{cuentaId}")
    public Cuenta update(@RequestBody Cuenta cuenta) {
        cuentaService.update(cuenta);
        return cuenta;
    }

    @DeleteMapping("/{cuentaId}")
    public void delete(@PathVariable("cuentaId") Integer cuentaId) {
        cuentaService.delete(cuentaId);
    }
}