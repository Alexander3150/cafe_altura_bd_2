package com.example.cafe_altura_bd.service.impl;

import com.example.cafe_altura_bd.entities.*;
import com.example.cafe_altura_bd.exception.ResourceNotFoundException;
import com.example.cafe_altura_bd.repositories.*;
import com.example.cafe_altura_bd.service.ProductoPresentacionService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service @Transactional @RequiredArgsConstructor
public class ProductoPresentacionServiceImpl implements ProductoPresentacionService {

    private final ProductoPresentacionRepository repo;
    private final TipoCafeRepository tipoRepo;
    private final TamanoPresentacionRepository tamanoRepo;
    private final CategoriaCafeRepository categoriaRepo;
    private final TipoGranoCafeRepository granoRepo;

    @Override public List<ProductoPresentacion> findAll(){ return repo.findAll(); }

    @Override public ProductoPresentacion findBySku(String sku){
        return repo.findById(sku).orElseThrow(() -> new ResourceNotFoundException("SKU no encontrado: " + sku));
    }

    @Override public ProductoPresentacion create(ProductoPresentacion p){
        // asegura referencias válidas (opcional si usas ids desde UI)
        if (p.getTipo()!=null && p.getTipo().getId()!=null)
            p.setTipo(tipoRepo.findById(p.getTipo().getId()).orElseThrow(() -> new ResourceNotFoundException("TipoCafe inválido")));
        if (p.getTamano()!=null && p.getTamano().getId()!=null)
            p.setTamano(tamanoRepo.findById(p.getTamano().getId()).orElseThrow(() -> new ResourceNotFoundException("Tamaño inválido")));
        if (p.getCategoria()!=null && p.getCategoria().getId()!=null)
            p.setCategoria(categoriaRepo.findById(p.getCategoria().getId()).orElseThrow(() -> new ResourceNotFoundException("Categoría inválida")));
        if (p.getGrano()!=null && p.getGrano().getId()!=null)
            p.setGrano(granoRepo.findById(p.getGrano().getId()).orElseThrow(() -> new ResourceNotFoundException("Grano inválido")));
        return repo.save(p);
    }

    @Override public ProductoPresentacion update(String sku, ProductoPresentacion p){
        ProductoPresentacion a = findBySku(sku);
        a.setNombre(p.getNombre());
        a.setPrecioLista(p.getPrecioLista());
        a.setStock(p.getStock());
        if (p.getTipo()!=null) a.setTipo(tipoRepo.findById(p.getTipo().getId()).orElseThrow(() -> new ResourceNotFoundException("TipoCafe inválido")));
        if (p.getTamano()!=null) a.setTamano(tamanoRepo.findById(p.getTamano().getId()).orElseThrow(() -> new ResourceNotFoundException("Tamaño inválido")));
        if (p.getCategoria()!=null) a.setCategoria(categoriaRepo.findById(p.getCategoria().getId()).orElseThrow(() -> new ResourceNotFoundException("Categoría inválida")));
        if (p.getGrano()!=null) a.setGrano(granoRepo.findById(p.getGrano().getId()).orElseThrow(() -> new ResourceNotFoundException("Grano inválido")));
        return repo.save(a);
    }

    @Override public void delete(String sku){ repo.delete(findBySku(sku)); }
}
