package com.example.demo.Service;

import com.example.demo.Entity.Producto;
import com.example.demo.Repository.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductoService {

    @Autowired
    ProductoRepository productoRepository;

    public List<Producto> getProducto() {
        return productoRepository.findAll();
    }

    public Optional<Producto> getProducto(Integer id) {
        return productoRepository.findById(id);
    }

    public void save(Producto producto) {
        productoRepository.save(producto);
    }

    public void Update(Producto producto) {
        productoRepository.save(producto);
    }

    public void delete(Integer id) {
        productoRepository.deleteById(id);
    }

}
