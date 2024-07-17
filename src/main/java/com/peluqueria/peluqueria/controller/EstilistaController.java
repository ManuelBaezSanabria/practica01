/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.peluqueria.peluqueria.controller;

import com.peluqueria.peluqueria.domain.Estilista;
import com.peluqueria.peluqueria.service.EstilistaService;
import com.peluqueria.peluqueria.service.FirebaseStorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author AMD
 */
@Controller
@RequestMapping("/estilista")
public class EstilistaController {
    
    @Autowired
    private EstilistaService estilistaService;
    
    @GetMapping("/listado-admin")
    public String listadoAdmin(Model model){
        var lista = estilistaService.getEstilistas();
        model.addAttribute("estilistas", lista);
        model.addAttribute("totalEstilistas", lista.size());
        return "/estilista/listado-admin";
    }
    
    @GetMapping("/listado")
    public String listado(Model model){
        var lista = estilistaService.getEstilistas();
        model.addAttribute("estilistas", lista);
        model.addAttribute("totalEstilistas", lista.size());
        return "/estilista/listado";
    }
    
    @Autowired
    private FirebaseStorageService firebaseStorageService;
    
    @PostMapping("/guardar")
        public String guardar(Estilista estilista, @RequestParam MultipartFile imagenFile){
            if (!imagenFile.isEmpty()){
                //Se sube al storage
                estilistaService.save(estilista);
                String rutaImagen=firebaseStorageService.cargaImagen(imagenFile, "estilista", estilista.getEstilistaid());
                estilista.setImagenurl(rutaImagen);
            }
            estilistaService.save(estilista);
        return "redirect:/estilista/listado-admin";
        }
    
    @GetMapping("eliminar/{idEstilista}")
    public String eliminar(Estilista estilista){
        estilistaService.delete(estilista);
        return "redirect:/estilista/listado-admin";
    }
    
    @GetMapping("modificar/{estilistaid}")
    public String modificar(Estilista estilista, Model model){
        estilista = estilistaService.getEstilista(estilista);
        model.addAttribute("estilista", estilista );
        return "/estilista/modifica";
    }
    
}
