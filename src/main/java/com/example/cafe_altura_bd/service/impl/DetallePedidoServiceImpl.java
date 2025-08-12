package com.example.cafe_altura_bd.service.impl;

import com.example.cafe_altura_bd.entities.*;
import com.example.cafe_altura_bd.exception.ResourceNotFoundException;
import com.example.cafe_altura_bd.repositories.*;
import com.example.cafe_altura_bd.service.DetallePedidoService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service @Transactional @RequiredArgsConstructor
public class DetallePedidoServiceImpl implements DetallePedidoService {

    private final DetallePedidoRepository repo;
    private final PedidoRepository pedidoRepo;
    private final ProductoPresentacionRepository productoRepo;

    @Override public List<DetallePedido> findAll(){ return repo.findAll(); }

    @Override public DetallePedido findById(Long id){
        return repo.findById(id).orElseThrow(() -> new ResourceNotFoundException("Detalle no encontrado: " + id));
    }

    @Override public List<DetallePedido> findByPedido(Long noOrden){
        Pedido p = pedidoRepo.findById(noOrden).orElseThrow(() -> new ResourceNotFoundException("Pedido no encontrado: " + noOrden));
        return repo.findByPedido(p);
    }

    @Override public DetallePedido create(DetallePedido d, Long noOrden, String sku){
        Pedido pedido = pedidoRepo.findById(noOrden).orElseThrow(() -> new ResourceNotFoundException("Pedido no encontrado: " + noOrden));
        ProductoPresentacion prod = productoRepo.findById(sku).orElseThrow(() -> new ResourceNotFoundException("SKU no encontrado: " + sku));
        d.setPedido(pedido);
        d.setProducto(prod);
        return repo.save(d);
    }

    @Override public DetallePedido update(Long id, DetallePedido d){
        DetallePedido a = findById(id);
        a.setCantidad(d.getCantidad());
        a.setPrecioVenta(d.getPrecioVenta());
        if (d.getProducto()!=null) {
            ProductoPresentacion prod = productoRepo.findById(d.getProducto().getSku()).orElseThrow(() -> new ResourceNotFoundException("SKU inválido"));
            a.setProducto(prod);
        }
        return repo.save(a);
    }

    @Override public void delete(Long id){ repo.delete(findById(id)); }
}
