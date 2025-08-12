package com.example.cafe_altura_bd.repositories;

import com.example.cafe_altura_bd.entities.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PedidoRepository extends JpaRepository<Pedido, Long> { }
