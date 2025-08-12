package com.example.cafe_altura_bd.controller;

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

    @GetMapping public List<ProductoPresentacion> list(){ return service.findAll(); }
    @GetMapping("/{sku}") public ProductoPresentacion get(@PathVariable String sku){ return service.findBySku(sku); }
    @PostMapping public ResponseEntity<ProductoPresentacion> create(@RequestBody ProductoPresentacion p){ return ResponseEntity.ok(service.create(p)); }
    @PutMapping("/{sku}") public ProductoPresentacion update(@PathVariable String sku, @RequestBody ProductoPresentacion p){ return service.update(sku, p); }
    @DeleteMapping("/{sku}") public void delete(@PathVariable String sku){ service.delete(sku); }
}
