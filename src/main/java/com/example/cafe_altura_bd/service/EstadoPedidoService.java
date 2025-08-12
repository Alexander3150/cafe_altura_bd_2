package com.example.cafe_altura_bd.service;

import com.example.cafe_altura_bd.entities.EstadoPedido;
import java.util.List;

public interface EstadoPedidoService {
    List<EstadoPedido> findAll();
    EstadoPedido findById(Integer id);
    EstadoPedido create(EstadoPedido e);
    EstadoPedido update(Integer id, EstadoPedido e);
    void delete(Integer id);
}