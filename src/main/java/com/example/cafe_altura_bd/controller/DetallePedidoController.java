package com.example.cafe_altura_bd.controller;

import com.example.cafe_altura_bd.entities.DetallePedido;
import com.example.cafe_altura_bd.service.DetallePedidoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/detalles")
@RequiredArgsConstructor
public class DetallePedidoController {

    private final DetallePedidoService service;

    @GetMapping public List<DetallePedido> list(){ return service.findAll(); }

    @GetMapping("/pedido/{noOrden}")
    public List<DetallePedido> byPedido(@PathVariable Long noOrden){
        return service.findByPedido(noOrden);
    }

    // Crear detalle asociando pedido y sku vía path params
    @PostMapping("/pedido/{noOrden}/producto/{sku}")
    public ResponseEntity<DetallePedido> create(@PathVariable Long noOrden,
                                                @PathVariable String sku,
                                                @RequestBody DetallePedido d){
        return ResponseEntity.ok(service.create(d, noOrden, sku));
    }

    @PutMapping("/{id}")
    public DetallePedido update(@PathVariable Long id, @RequestBody DetallePedido d){
        return service.update(id, d);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){ service.delete(id); }
}

