package com.example.demo.Controller;

import com.example.demo.Entity.Producto;
import com.example.demo.Service.ProductoService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/producto")
@RequiredArgsConstructor
public class ProductoController {

    private final ProductoService productoService;

    @GetMapping
    public List<Producto> getAll(){
        return productoService.getProducto();
    }

    @GetMapping("/{productoId}")
    public Optional<Producto> getById(@PathVariable("productoId") Integer productoId){
        return productoService.getProducto(productoId);
    }

    @PostMapping
    public Producto save(@RequestBody Producto producto){
        productoService.save(producto);
        return producto;
    }

    @PatchMapping("/{productoId}")
    public Producto Update(@RequestBody Producto producto){
        productoService.Update(producto);
        return producto;
    }

    @DeleteMapping("/{productoId}")
    public void saveUpdate(@PathVariable("productoId") Integer productoId){
        productoService.delete(productoId);
    }

}
