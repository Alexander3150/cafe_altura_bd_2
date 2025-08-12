package com.example.cafe_altura_bd.service.impl;

import com.example.cafe_altura_bd.entities.TipoCafe;
import com.example.cafe_altura_bd.exception.ResourceNotFoundException;
import com.example.cafe_altura_bd.repositories.TipoCafeRepository;
import com.example.cafe_altura_bd.service.TipoCafeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service @Transactional @RequiredArgsConstructor
public class TipoCafeServiceImpl implements TipoCafeService {

    private final TipoCafeRepository repo;

    @Override public List<TipoCafe> findAll() { return repo.findAll(); }

    @Override public TipoCafe findById(Integer id) {
        return repo.findById(id).orElseThrow(() -> new ResourceNotFoundException("TipoCafe no encontrado: " + id));
    }

    @Override public TipoCafe create(TipoCafe e) { return repo.save(e); }

    @Override public TipoCafe update(Integer id, TipoCafe e) {
        TipoCafe actual = findById(id);
        actual.setNombre(e.getNombre());
        return repo.save(actual);
    }

    @Override public void delete(Integer id) { repo.delete(findById(id)); }
}
