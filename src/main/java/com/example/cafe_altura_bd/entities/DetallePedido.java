package com.example.cafe_altura_bd.entities;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;

@Entity
@Table(
    name = "detalles_pedido",
    uniqueConstraints = @UniqueConstraint(name = "uq_detalle", columnNames = {"no_orden","sku"})
)
@Getter @Setter @NoArgsConstructor @AllArgsConstructor @Builder
public class DetallePedido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_detalle")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "no_orden", nullable = false)
    private Pedido pedido;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "sku", nullable = false)
    private ProductoPresentacion producto;

    @Column(nullable = false)
    private Integer cantidad;

    @Column(name = "precio_venta", nullable = false, precision = 10, scale = 2)
    private BigDecimal precioVenta;
}
