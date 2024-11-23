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

    @CrossOrigin("http://localhost:5173")
    @GetMapping
    public List<Producto> getAll(){
        return productoService.getProducto();
    }

    @CrossOrigin("http://localhost:5173")
    @GetMapping("/{productoId}")
    public Optional<Producto> getById(@PathVariable("productoId") Integer productoId){
        return productoService.getProducto(productoId);
    }

    @CrossOrigin("http://localhost:5173")
    @PostMapping
    public Producto save(@RequestBody Producto producto){
        productoService.save(producto);
        return producto;
    }

    @CrossOrigin("http://localhost:5173")
    @PatchMapping("/{productoId}")
    public Producto Update(@RequestBody Producto producto){
        productoService.Update(producto);
        return producto;
    }

    @CrossOrigin("http://localhost:5173")
    @DeleteMapping("/{usuarioId}")
    public void saveUpdate(@PathVariable("productoId") Integer productoId){
        productoService.delete(productoId);
    }

    /*
    @PostMapping(value = "demo")
    public String welcome() {
        return "welcome from secure endpoint";
    }
    */

}
