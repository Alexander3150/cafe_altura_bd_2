package com.example.cafe_altura_bd.controller;

import com.example.cafe_altura_bd.entities.Pedido;
import com.example.cafe_altura_bd.service.PedidoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/pedidos")
@RequiredArgsConstructor
public class PedidoController {

    private final PedidoService service;

    @GetMapping public List<Pedido> list(){ return service.findAll(); }
    @GetMapping("/{noOrden}") public Pedido get(@PathVariable Long noOrden){ return service.findById(noOrden); }
    @PostMapping public ResponseEntity<Pedido> create(@RequestBody Pedido p){ return ResponseEntity.ok(service.create(p)); }
    @PutMapping("/{noOrden}") public Pedido update(@PathVariable Long noOrden, @RequestBody Pedido p){ return service.update(noOrden, p); }
    @DeleteMapping("/{noOrden}") public void delete(@PathVariable Long noOrden){ service.delete(noOrden); }
}
