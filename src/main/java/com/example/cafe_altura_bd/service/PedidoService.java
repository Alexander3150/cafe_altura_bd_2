package com.example.cafe_altura_bd.service;

import com.example.cafe_altura_bd.entities.Pedido;
import java.util.List;

public interface PedidoService {
    List<Pedido> findAll();
    Pedido findById(Long id);
    Pedido create(Pedido p);
    Pedido update(Long id, Pedido p);
    void delete(Long id);
}