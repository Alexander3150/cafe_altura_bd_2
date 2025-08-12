package com.example.cafe_altura_bd.service;

import com.example.cafe_altura_bd.entities.TipoCafe;
import java.util.List;

public interface TipoCafeService {
    List<TipoCafe> findAll();
    TipoCafe findById(Integer id);
    TipoCafe create(TipoCafe e);
    TipoCafe update(Integer id, TipoCafe e);
    void delete(Integer id);
}
