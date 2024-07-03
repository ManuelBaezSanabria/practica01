package com.practica01.practica01.service.impl;

import com.practica01.practica01.dao.ArbolDao;
import com.practica01.practica01.domain.Arbol;
import com.practica01.practica01.service.ArbolService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ArbolServiceImpl implements ArbolService {
    
    @Autowired
    private ArbolDao arbolDao;

    @Override
    public List<Arbol> getArbols() {
        var lista = arbolDao.findAll();
        return lista;
    }

    @Override
    public Arbol getArbol(Arbol arbol) {
       return arbolDao.findById(arbol.getIdArbol()).orElse(null);
    }

    @Override
    public void save(Arbol arbol) {
        arbolDao.save(arbol);
    }

    @Override
    public void delete(Arbol arbol) {
        arbolDao.delete(arbol);
    }
}
