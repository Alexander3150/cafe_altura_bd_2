package com.example.cafe_altura_bd.service;

import com.example.cafe_altura_bd.entities.ProductoPresentacion;
import java.util.List;

public interface ProductoPresentacionService {
    List<ProductoPresentacion> findAll();
    ProductoPresentacion findBySku(String sku);
    ProductoPresentacion create(ProductoPresentacion p);
    ProductoPresentacion update(String sku, ProductoPresentacion p);
    void delete(String sku);
}