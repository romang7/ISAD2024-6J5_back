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

    @CrossOrigin("http://localhost:5173")
    @GetMapping
    public List<Cliente> getAll(){
        return clienteService.getCliente();
    }

    @CrossOrigin("http://localhost:5173")
    @GetMapping("/{productoId}")
    public Optional<Cliente> getById(@PathVariable("clienteId") Integer clienteId){
        return clienteService.getCliente(clienteId);
    }

    @CrossOrigin("http://localhost:5173")
    @PostMapping
    public Cliente save(@RequestBody Cliente cliente){
        clienteService.save(cliente);
        return cliente;
    }

    @CrossOrigin("http://localhost:5173")
    @PatchMapping("/{clienteId}")
    public Cliente Update(@RequestBody Cliente cliente){
        clienteService.Update(cliente);
        return cliente;
    }

    @CrossOrigin("http://localhost:5173")
    @DeleteMapping("/{clienteId}")
    public void saveUpdate(@PathVariable("clienteId") Integer clienteId){
        clienteService.delete(clienteId);
    }



}
