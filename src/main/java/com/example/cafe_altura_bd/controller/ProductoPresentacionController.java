package com.example.cafe_altura_bd.controller;

import com.example.cafe_altura_bd.dto.ProductoPresentacionResponse;
import com.example.cafe_altura_bd.entities.ProductoPresentacion;
import com.example.cafe_altura_bd.service.ProductoPresentacionService;
import lombok.RequiredArgsConstructor;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/productos")
@RequiredArgsConstructor
public class ProductoPresentacionController {

    private final ProductoPresentacionService service;

    /** Listar todos los productos como DTO (evita proxys LAZY) */
    @GetMapping
    public List<ProductoPresentacionResponse> list() {
        List<ProductoPresentacion> productos = service.findAll();
        return productos.stream().map(ProductoPresentacionResponse::from).toList();
    }

    /** Obtener 1 producto (DTO) */
    @GetMapping("/{sku}")
    public ProductoPresentacionResponse get(@PathVariable String sku) {
        return ProductoPresentacionResponse.from(service.findBySku(sku));
    }

    @PostMapping public ResponseEntity<ProductoPresentacion> create(@RequestBody ProductoPresentacion p){ return ResponseEntity.ok(service.create(p)); }
    @PutMapping("/{sku}") public ProductoPresentacion update(@PathVariable String sku, @RequestBody ProductoPresentacion p){ return service.update(sku, p); }
    @DeleteMapping("/{sku}") public void delete(@PathVariable String sku){ service.delete(sku); }
}
