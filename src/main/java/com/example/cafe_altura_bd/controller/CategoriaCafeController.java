package com.example.cafe_altura_bd.controller;

import com.example.cafe_altura_bd.entities.CategoriaCafe;
import com.example.cafe_altura_bd.service.CategoriaCafeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/categorias")
@RequiredArgsConstructor
public class CategoriaCafeController {

    private final CategoriaCafeService service;

    @GetMapping
    public List<CategoriaCafe> list() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public CategoriaCafe get(@PathVariable Integer id) {
        return service.findById(id);
    }

    @PostMapping
    public ResponseEntity<CategoriaCafe> create(@RequestBody CategoriaCafe e) {
        return ResponseEntity.ok(service.create(e));
    }

    @PutMapping("/{id}")
    public CategoriaCafe update(@PathVariable Integer id, @RequestBody CategoriaCafe e) {
        return service.update(id, e);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        service.delete(id);
    }
}
