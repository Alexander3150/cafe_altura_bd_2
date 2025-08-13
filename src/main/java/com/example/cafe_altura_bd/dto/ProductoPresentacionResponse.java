package com.example.cafe_altura_bd.dto;

import com.example.cafe_altura_bd.entities.ProductoPresentacion;

import java.math.BigDecimal;

public record ProductoPresentacionResponse(
        String sku,
        String nombre,
        BigDecimal precioLista,
        Integer stock,
        Integer idTipo,     String tipoNombre,
        Integer idTamano,   String tamanoNombre,
        Integer idCategoria,String categoriaNombre,
        Integer idGrano,    String granoNombre
) {
    public static ProductoPresentacionResponse from(ProductoPresentacion p) {
        return new ProductoPresentacionResponse(
                p.getSku(),
                p.getNombre(),
                p.getPrecioLista(),
                p.getStock(),
                p.getTipo().getId(),     p.getTipo().getNombre(),
                p.getTamano().getId(),   p.getTamano().getNombre(),
                p.getCategoria().getId(),p.getCategoria().getNombre(),
                p.getGrano().getId(),    p.getGrano().getNombre()
        );
    }
}
