/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.peluqueria.peluqueria.service.impl;

import com.peluqueria.peluqueria.dao.EstilistaDao;
import com.peluqueria.peluqueria.domain.Estilista;
import com.peluqueria.peluqueria.service.EstilistaService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author AMD
 */
@Service
public class EstilistaServiceImpl implements EstilistaService {
    
    @Autowired
    private EstilistaDao estilistaDao;

    @Override
    public List<Estilista> getEstilistas() {
        var lista = estilistaDao.findAll();
        return lista;
    }

    @Override
    public Estilista getEstilista(Estilista estilista) {
        return estilistaDao.findById(estilista.getEstilistaid()).orElse(null);
    }

    @Override
    public void save(Estilista estilista) {
       estilistaDao.save(estilista);
    }

    @Override
    public void delete(Estilista estilista) {
        estilistaDao.delete(estilista);
    }
    
}
