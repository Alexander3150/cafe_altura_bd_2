package com.example.cafe_altura_bd.service;

import com.example.cafe_altura_bd.entities.TamanoPresentacion;
import java.util.List;

public interface TamanoPresentacionService {
    List<TamanoPresentacion> findAll();
    TamanoPresentacion findById(Integer id);
    TamanoPresentacion create(TamanoPresentacion e);
    TamanoPresentacion update(Integer id, TamanoPresentacion e);
    void delete(Integer id);
}