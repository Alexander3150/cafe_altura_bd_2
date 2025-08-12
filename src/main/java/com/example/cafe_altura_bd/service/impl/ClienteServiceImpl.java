package com.example.cafe_altura_bd.service.impl;

import com.example.cafe_altura_bd.entities.Cliente;
import com.example.cafe_altura_bd.exception.ResourceNotFoundException;
import com.example.cafe_altura_bd.repositories.ClienteRepository;
import com.example.cafe_altura_bd.service.ClienteService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service @Transactional @RequiredArgsConstructor
public class ClienteServiceImpl implements ClienteService {
    private final ClienteRepository repo;
    @Override public List<Cliente> findAll(){ return repo.findAll(); }
    @Override public Cliente findById(Long id){ return repo.findById(id).orElseThrow(() -> new ResourceNotFoundException("Cliente no encontrado: " + id)); }
    @Override public Cliente create(Cliente c){ return repo.save(c); }
    @Override public Cliente update(Long id, Cliente c){
        Cliente a = findById(id);
        a.setNombres(c.getNombres());
        a.setApellidos(c.getApellidos());
        a.setCorreo(c.getCorreo());
        a.setDireccion(c.getDireccion());
        return repo.save(a);
    }
    @Override public void delete(Long id){ repo.delete(findById(id)); }
}
