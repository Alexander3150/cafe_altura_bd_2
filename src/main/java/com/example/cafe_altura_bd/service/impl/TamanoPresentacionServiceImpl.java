package com.example.cafe_altura_bd.service.impl;

import com.example.cafe_altura_bd.entities.TamanoPresentacion;
import com.example.cafe_altura_bd.exception.ResourceNotFoundException;
import com.example.cafe_altura_bd.repositories.TamanoPresentacionRepository;
import com.example.cafe_altura_bd.service.TamanoPresentacionService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service @Transactional @RequiredArgsConstructor
public class TamanoPresentacionServiceImpl implements TamanoPresentacionService {
    private final TamanoPresentacionRepository repo;
    @Override public List<TamanoPresentacion> findAll(){ return repo.findAll(); }
    @Override public TamanoPresentacion findById(Integer id){
        return repo.findById(id).orElseThrow(() -> new ResourceNotFoundException("Tamaño no encontrado: " + id));
    }
    @Override public TamanoPresentacion create(TamanoPresentacion e){ return repo.save(e); }
    @Override public TamanoPresentacion update(Integer id, TamanoPresentacion e){
        TamanoPresentacion a = findById(id);
        a.setNombre(e.getNombre());
        return repo.save(a);
    }
    @Override public void delete(Integer id){ repo.delete(findById(id)); }
}
