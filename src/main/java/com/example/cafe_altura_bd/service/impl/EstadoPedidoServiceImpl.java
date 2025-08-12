package com.example.cafe_altura_bd.service.impl;

import com.example.cafe_altura_bd.entities.EstadoPedido;
import com.example.cafe_altura_bd.exception.ResourceNotFoundException;
import com.example.cafe_altura_bd.repositories.EstadoPedidoRepository;
import com.example.cafe_altura_bd.service.EstadoPedidoService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class EstadoPedidoServiceImpl implements EstadoPedidoService {

    private final EstadoPedidoRepository repo;

    @Override
    public List<EstadoPedido> findAll() {
        return repo.findAll();
    }

    @Override
    public EstadoPedido findById(Integer id) {
        return repo.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("Estado de pedido no encontrado: " + id));
    }

    @Override
    public EstadoPedido create(EstadoPedido e) {
        return repo.save(e);
    }

    @Override
    public EstadoPedido update(Integer id, EstadoPedido e) {
        EstadoPedido actual = findById(id);
        actual.setNombre(e.getNombre());
        return repo.save(actual);
    }

    @Override
    public void delete(Integer id) {
        repo.delete(findById(id));
    }
}
