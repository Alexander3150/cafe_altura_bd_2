package com.example.cafe_altura_bd.service.impl;

import com.example.cafe_altura_bd.entities.*;
import com.example.cafe_altura_bd.exception.ResourceNotFoundException;
import com.example.cafe_altura_bd.repositories.*;
import com.example.cafe_altura_bd.service.PedidoService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service @Transactional @RequiredArgsConstructor
public class PedidoServiceImpl implements PedidoService {

    private final PedidoRepository repo;
    private final ClienteRepository clienteRepo;
    private final EstadoPedidoRepository estadoRepo;

    @Override public List<Pedido> findAll(){ return repo.findAll(); }

    @Override public Pedido findById(Long id){
        return repo.findById(id).orElseThrow(() -> new ResourceNotFoundException("Pedido no encontrado: " + id));
    }

    @Override public Pedido create(Pedido p){
        if (p.getCliente()!=null && p.getCliente().getId()!=null)
            p.setCliente(clienteRepo.findById(p.getCliente().getId()).orElseThrow(() -> new ResourceNotFoundException("Cliente inválido")));
        if (p.getEstado()!=null && p.getEstado().getId()!=null)
            p.setEstado(estadoRepo.findById(p.getEstado().getId()).orElseThrow(() -> new ResourceNotFoundException("Estado inválido")));
        return repo.save(p);
    }

    @Override public Pedido update(Long id, Pedido p){
        Pedido a = findById(id);
        if (p.getCliente()!=null) a.setCliente(clienteRepo.findById(p.getCliente().getId()).orElseThrow(() -> new ResourceNotFoundException("Cliente inválido")));
        if (p.getEstado()!=null)  a.setEstado(estadoRepo.findById(p.getEstado().getId()).orElseThrow(() -> new ResourceNotFoundException("Estado inválido")));
        if (p.getFecha()!=null)   a.setFecha(p.getFecha());
        return repo.save(a);
    }

    @Override public void delete(Long id){ repo.delete(findById(id)); }
}
