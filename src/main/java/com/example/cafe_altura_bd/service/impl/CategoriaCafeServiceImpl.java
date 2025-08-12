package com.example.cafe_altura_bd.service.impl;

import com.example.cafe_altura_bd.entities.CategoriaCafe;
import com.example.cafe_altura_bd.exception.ResourceNotFoundException;
import com.example.cafe_altura_bd.repositories.CategoriaCafeRepository;
import com.example.cafe_altura_bd.service.CategoriaCafeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class CategoriaCafeServiceImpl implements CategoriaCafeService {

    private final CategoriaCafeRepository repo;

    @Override
    public List<CategoriaCafe> findAll() {
        return repo.findAll();
    }

    @Override
    public CategoriaCafe findById(Integer id) {
        return repo.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("Categoría no encontrada: " + id));
    }

    @Override
    public CategoriaCafe create(CategoriaCafe e) {
        return repo.save(e);
    }

    @Override
    public CategoriaCafe update(Integer id, CategoriaCafe e) {
        CategoriaCafe actual = findById(id);
        actual.setNombre(e.getNombre());
        return repo.save(actual);
    }

    @Override
    public void delete(Integer id) {
        repo.delete(findById(id));
    }
}
