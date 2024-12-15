package com.example.demo.Controller;

import com.example.demo.Entity.Cliente;
import com.example.demo.Service.ClienteService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/cliente")
@RequiredArgsConstructor
public class ClienteController {

    private final ClienteService clienteService;

    @GetMapping
    public List<Cliente> getAll() {
        return clienteService.getCliente();
    }

    @GetMapping("/{id}")
    public Optional<Cliente> getById(@PathVariable("id") Integer id) {
        return clienteService.getCliente(id);
    }

    @PostMapping()
    public Cliente save(@RequestBody Cliente cliente) {
        clienteService.save(cliente);
        return cliente;
    }

    @PatchMapping("/{id}")
    public Cliente update(@RequestBody Cliente cliente) {
        clienteService.update(cliente);
        return cliente;
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Integer id) {
        clienteService.delete(id);
    }
}