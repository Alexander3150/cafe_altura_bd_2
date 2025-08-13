package com.example.cafe_altura_bd.controller;

import com.example.cafe_altura_bd.dto.DetallePedidoResponse;
import com.example.cafe_altura_bd.entities.DetallePedido;
import com.example.cafe_altura_bd.service.DetallePedidoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/detalles", produces = MediaType.APPLICATION_JSON_VALUE)
@RequiredArgsConstructor
public class DetallePedidoController {

    private final DetallePedidoService service;

    @GetMapping
    public List<DetallePedidoResponse> list() {
        return service.findAll().stream().map(DetallePedidoResponse::from).toList();
    }

    @GetMapping("/{id}")
    public DetallePedidoResponse getById(@PathVariable Long id) {
        return DetallePedidoResponse.from(service.findById(id));
    }

    @GetMapping("/pedido/{noOrden}")
    public List<DetallePedidoResponse> byPedido(@PathVariable Long noOrden) {
        return service.findByPedido(noOrden).stream().map(DetallePedidoResponse::from).toList();
    }

    // Forma 1: crear con path params
    @PostMapping(value = "/pedido/{noOrden}/producto/{sku}",
                 consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<DetallePedidoResponse> createWithPath(
            @PathVariable Long noOrden,
            @PathVariable String sku,
            @RequestBody DetallePedido d) {
        var creado = service.create(d, noOrden, sku);
        return ResponseEntity.ok(DetallePedidoResponse.from(creado));
    }

    // Forma 2: crear con objetos embebidos en el body
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<DetallePedidoResponse> createBody(@RequestBody DetallePedido d) {
        if (d.getPedido() == null || d.getPedido().getNoOrden() == null)
            throw new IllegalArgumentException("Falta pedido.noOrden");
        if (d.getProducto() == null || d.getProducto().getSku() == null)
            throw new IllegalArgumentException("Falta producto.sku");

        var creado = service.create(d, d.getPedido().getNoOrden(), d.getProducto().getSku());
        return ResponseEntity.ok(DetallePedidoResponse.from(creado));
    }

    @PutMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public DetallePedidoResponse update(@PathVariable Long id, @RequestBody DetallePedido d) {
        return DetallePedidoResponse.from(service.update(id, d));
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}
