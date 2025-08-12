package com.example.cafe_altura_bd.service;

import com.example.cafe_altura_bd.entities.DetallePedido;
import java.util.List;

public interface DetallePedidoService {
    List<DetallePedido> findAll();
    DetallePedido findById(Long id);
    List<DetallePedido> findByPedido(Long noOrden);
    DetallePedido create(DetallePedido d, Long noOrden, String sku);
    DetallePedido update(Long id, DetallePedido d);
    void delete(Long id);
}
