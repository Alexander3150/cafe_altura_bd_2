package com.example.cafe_altura_bd.service;

import com.example.cafe_altura_bd.entities.CategoriaCafe;
import java.util.List;

public interface CategoriaCafeService {
    List<CategoriaCafe> findAll();
    CategoriaCafe findById(Integer id);
    CategoriaCafe create(CategoriaCafe e);
    CategoriaCafe update(Integer id, CategoriaCafe e);
    void delete(Integer id);
}