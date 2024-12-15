package com.example.demo.Service;

import com.example.demo.Entity.Cliente;
import com.example.demo.Repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    public List<Cliente> getCliente() {
        return clienteRepository.findAll();
    }

    public Optional<Cliente> getCliente(Integer id) {
        return clienteRepository.findById(id);
    }

    public void save(Cliente cliente) {
        clienteRepository.save(cliente);
    }

    public void update(Cliente cliente) {
        clienteRepository.save(cliente);
    }

    public void delete(Integer id) {
        clienteRepository.deleteById(id);
    }
}