package com.example.cafe_altura_bd.dto;

import com.example.cafe_altura_bd.entities.DetallePedido;
import java.math.BigDecimal;

public record DetallePedidoResponse(
        Long id,
        Long noOrden,
        String sku,
        Integer cantidad,
        BigDecimal precioVenta
) {
    public static DetallePedidoResponse from(DetallePedido d) {
        return new DetallePedidoResponse(
                d.getId(),
                d.getPedido().getNoOrden(),
                d.getProducto().getSku(),
                d.getCantidad(),
                d.getPrecioVenta()
        );
    }
}
