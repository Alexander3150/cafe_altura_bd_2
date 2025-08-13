package com.example.cafe_altura_bd.controller;

import com.example.cafe_altura_bd.dto.DetallePedidoResponse;
import com.example.cafe_altura_bd.dto.PedidoFullResponse;
import com.example.cafe_altura_bd.dto.PedidoResumenResponse;
import com.example.cafe_altura_bd.entities.DetallePedido;
import com.example.cafe_altura_bd.entities.Pedido;
import com.example.cafe_altura_bd.service.DetallePedidoService;
import com.example.cafe_altura_bd.service.PedidoService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

@RestController
@RequestMapping("/api/pedidos")
@RequiredArgsConstructor
public class PedidoController {

    private final PedidoService pedidoService;
    private final DetallePedidoService detalleService;

    /** Listar todos los pedidos (resumen + totales) */
    @GetMapping
    public List<PedidoResumenResponse> list() {
        List<Pedido> pedidos = pedidoService.findAll();
        return pedidos.stream().map(p -> {
            List<DetallePedido> dets = detalleService.findByPedido(p.getNoOrden());
            int items = dets.stream().mapToInt(DetallePedido::getCantidad).sum();
            BigDecimal total = dets.stream()
                    .map(d -> d.getPrecioVenta().multiply(BigDecimal.valueOf(d.getCantidad())))
                    .reduce(BigDecimal.ZERO, BigDecimal::add);
            return PedidoResumenResponse.of(p, items, total);
        }).toList();
    }

    /** Mostrar un pedido con todos sus detalles */
    @GetMapping("/{noOrden}/full")
    public PedidoFullResponse getFull(@PathVariable Long noOrden) {
        Pedido p = pedidoService.findById(noOrden);
        List<DetallePedidoResponse> detalles = detalleService.findByPedido(noOrden)
                .stream().map(DetallePedidoResponse::from).toList();

        int items = detalles.stream().mapToInt(DetallePedidoResponse::cantidad).sum();
        BigDecimal total = detalles.stream()
                .map(d -> d.precioVenta().multiply(BigDecimal.valueOf(d.cantidad())))
                .reduce(BigDecimal.ZERO, BigDecimal::add);

        return PedidoFullResponse.of(p, detalles, items, total);
    }
}
