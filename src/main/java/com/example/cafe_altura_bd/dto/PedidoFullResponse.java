package com.example.cafe_altura_bd.dto;

import com.example.cafe_altura_bd.entities.Pedido;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

public record PedidoFullResponse(
        Long noOrden,
        LocalDateTime fecha,
        Long clienteId,
        String clienteNombre,
        Integer estadoId,
        String estadoNombre,
        List<DetallePedidoResponse> detalles,
        Integer totalItems,
        BigDecimal totalImporte
) {
    public static PedidoFullResponse of(
            Pedido p, List<DetallePedidoResponse> detalles,
            Integer totalItems, BigDecimal totalImporte) {

        String clienteNom = p.getCliente().getNombres() + " " + p.getCliente().getApellidos();
        return new PedidoFullResponse(
                p.getNoOrden(),
                p.getFecha(),
                p.getCliente().getId(),
                clienteNom,
                p.getEstado().getId(),
                p.getEstado().getNombre(),
                detalles,
                totalItems,
                totalImporte
        );
    }
}
