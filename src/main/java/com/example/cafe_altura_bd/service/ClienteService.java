package com.example.cafe_altura_bd.service;

import com.example.cafe_altura_bd.entities.Cliente;
import java.util.List;

public interface ClienteService {
    List<Cliente> findAll();
    Cliente findById(Long id);
    Cliente create(Cliente c);
    Cliente update(Long id, Cliente c);
    void delete(Long id);
}