package com.example.cafe_altura_bd.controller;

import com.example.cafe_altura_bd.entities.TipoCafe;
import com.example.cafe_altura_bd.service.TipoCafeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/tipos-cafe")
@RequiredArgsConstructor
public class TipoCafeController {

    private final TipoCafeService service;

    @GetMapping public List<TipoCafe> list(){ return service.findAll(); }
    @GetMapping("/{id}") public TipoCafe get(@PathVariable Integer id){ return service.findById(id); }
    @PostMapping public ResponseEntity<TipoCafe> create(@RequestBody TipoCafe e){ return ResponseEntity.ok(service.create(e)); }
    @PutMapping("/{id}") public TipoCafe update(@PathVariable Integer id, @RequestBody TipoCafe e){ return service.update(id, e); }
    @DeleteMapping("/{id}") public void delete(@PathVariable Integer id){ service.delete(id); }
}
