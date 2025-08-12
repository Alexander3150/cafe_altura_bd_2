package com.example.cafe_altura_bd.controller;

import com.example.cafe_altura_bd.entities.TipoGranoCafe;
import com.example.cafe_altura_bd.service.TipoGranoCafeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/granos")
@RequiredArgsConstructor
public class TipoGranoCafeController {

    private final TipoGranoCafeService service;

    @GetMapping
    public List<TipoGranoCafe> list() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public TipoGranoCafe get(@PathVariable Integer id) {
        return service.findById(id);
    }

    @PostMapping
    public ResponseEntity<TipoGranoCafe> create(@RequestBody TipoGranoCafe e) {
        return ResponseEntity.ok(service.create(e));
    }

    @PutMapping("/{id}")
    public TipoGranoCafe update(@PathVariable Integer id, @RequestBody TipoGranoCafe e) {
        return service.update(id, e);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        service.delete(id);
    }
}
