package com.example.cafe_altura_bd.dto;

import com.example.cafe_altura_bd.entities.Pedido;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public record PedidoResumenResponse(
        Long noOrden,
        LocalDateTime fecha,
        Long clienteId,
        String clienteNombre,
        Integer estadoId,
        String estadoNombre,
        Integer totalItems,
        BigDecimal totalImporte
) {
    public static PedidoResumenResponse of(
            Pedido p, int totalItems, BigDecimal totalImporte) {
        String clienteNom = p.getCliente().getNombres() + " " + p.getCliente().getApellidos();
        return new PedidoResumenResponse(
                p.getNoOrden(),
                p.getFecha(),
                p.getCliente().getId(),
                clienteNom,
                p.getEstado().getId(),
                p.getEstado().getNombre(),
                totalItems,
                totalImporte
        );
    }
}
