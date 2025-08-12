package com.example.cafe_altura_bd.repositories;

import com.example.cafe_altura_bd.entities.DetallePedido;
import com.example.cafe_altura_bd.entities.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DetallePedidoRepository extends JpaRepository<DetallePedido, Long> {
    List<DetallePedido> findByPedido(Pedido pedido);
}
