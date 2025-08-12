// src/main/java/com/example/cafe_altura_bd/controller/TamanoPresentacionController.java
package com.example.cafe_altura_bd.controller;

import com.example.cafe_altura_bd.entities.TamanoPresentacion;
import com.example.cafe_altura_bd.service.TamanoPresentacionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tamanos")
@RequiredArgsConstructor
public class TamanoPresentacionController {

    private final TamanoPresentacionService service;

    @GetMapping
    public List<TamanoPresentacion> list() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public TamanoPresentacion get(@PathVariable Integer id) {
        return service.findById(id);
    }

    @PostMapping
    public ResponseEntity<TamanoPresentacion> create(@RequestBody TamanoPresentacion e) {
        return ResponseEntity.ok(service.create(e));
    }

    @PutMapping("/{id}")
    public TamanoPresentacion update(@PathVariable Integer id, @RequestBody TamanoPresentacion e) {
        return service.update(id, e);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        service.delete(id);
    }
}
