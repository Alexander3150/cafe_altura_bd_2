package com.example.cafe_altura_bd.entities;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;

@Entity
@Table(name = "producto_presentacion")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor @Builder
public class ProductoPresentacion {

    @Id
    @Column(name = "sku", length = 30)
    private String sku;

    @Column(nullable = false, length = 150)
    private String nombre;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_tipo", nullable = false)
    private TipoCafe tipo;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_tamano", nullable = false)
    private TamanoPresentacion tamano;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_categoria", nullable = false)
    private CategoriaCafe categoria;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_grano", nullable = false)
    private TipoGranoCafe grano;

    @Column(name = "precio_lista", nullable = false, precision = 10, scale = 2)
    private BigDecimal precioLista;

    @Column(nullable = false)
    private Integer stock;
}
