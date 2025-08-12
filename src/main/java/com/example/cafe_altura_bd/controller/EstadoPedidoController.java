package com.example.cafe_altura_bd.controller;

import com.example.cafe_altura_bd.entities.EstadoPedido;
import com.example.cafe_altura_bd.service.EstadoPedidoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/estados-pedido")
@RequiredArgsConstructor
public class EstadoPedidoController {

    private final EstadoPedidoService service;

    @GetMapping
    public List<EstadoPedido> list() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public EstadoPedido get(@PathVariable Integer id) {
        return service.findById(id);
    }

    @PostMapping
    public ResponseEntity<EstadoPedido> create(@RequestBody EstadoPedido e) {
        return ResponseEntity.ok(service.create(e));
    }

    @PutMapping("/{id}")
    public EstadoPedido update(@PathVariable Integer id, @RequestBody EstadoPedido e) {
        return service.update(id, e);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        service.delete(id);
    }
}
