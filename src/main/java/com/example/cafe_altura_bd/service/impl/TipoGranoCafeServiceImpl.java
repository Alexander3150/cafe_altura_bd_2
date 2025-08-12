package com.example.cafe_altura_bd.service.impl;

import com.example.cafe_altura_bd.entities.TipoGranoCafe;
import com.example.cafe_altura_bd.exception.ResourceNotFoundException;
import com.example.cafe_altura_bd.repositories.TipoGranoCafeRepository;
import com.example.cafe_altura_bd.service.TipoGranoCafeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class TipoGranoCafeServiceImpl implements TipoGranoCafeService {

    private final TipoGranoCafeRepository repo;

    @Override
    public List<TipoGranoCafe> findAll() {
        return repo.findAll();
    }

    @Override
    public TipoGranoCafe findById(Integer id) {
        return repo.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("Tipo de grano no encontrado: " + id));
    }

    @Override
    public TipoGranoCafe create(TipoGranoCafe e) {
        return repo.save(e);
    }

    @Override
    public TipoGranoCafe update(Integer id, TipoGranoCafe e) {
        TipoGranoCafe actual = findById(id);
        actual.setNombre(e.getNombre());
        return repo.save(actual);
    }

    @Override
    public void delete(Integer id) {
        repo.delete(findById(id));
    }
}
