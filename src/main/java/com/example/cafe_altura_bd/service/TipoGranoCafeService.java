package com.example.cafe_altura_bd.service;

import com.example.cafe_altura_bd.entities.TipoGranoCafe;
import java.util.List;

public interface TipoGranoCafeService {
    List<TipoGranoCafe> findAll();
    TipoGranoCafe findById(Integer id);
    TipoGranoCafe create(TipoGranoCafe e);
    TipoGranoCafe update(Integer id, TipoGranoCafe e);
    void delete(Integer id);
}