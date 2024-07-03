/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.practica01.practica01.service;

import com.practica01.practica01.domain.Arbol;
import java.util.List;

/**
 *
 * @author AMD
 */
public interface ArbolService  {
    //Se enuncia un método que recupera los registros de la tabla categoría dentro de un ArrayList,
    //pueden ser todos los registros o solo los activos
    public List<Arbol> getArbols();
    
    //Se obtiene un registro de la tabla arbol en un objeto arbol si el idArbol existe sino pasa un null
    public Arbol getArbol(Arbol arbol);
    
    //Se crea un nuevo registro en arbol si el objeto Arbol  NO tiene idArbol
    //se actualiza el registro en la tabla arbol si el objeto arbol tiene un idArbol
    public void save(Arbol arbol);
    
    //Se elimina el registro por idArbol
    public void delete(Arbol arbol);
}
