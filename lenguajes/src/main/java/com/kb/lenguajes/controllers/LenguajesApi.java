package com.kb.lenguajes.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.kb.lenguajes.models.Lenguaje;
import com.kb.lenguajes.services.LenguajeServicio;

@RestController
public class LenguajesApi {
    private final LenguajeServicio lServicio;

    public LenguajesApi(LenguajeServicio lServicio) {
        this.lServicio = lServicio;
    }

    @GetMapping("/api/languages")
    public List<Lenguaje> index(){
        return lServicio.allLenguajes();
    }

    @PostMapping("/api/languages")
    public Lenguaje create(@RequestParam(value="name")String name , @RequestParam(value="creator")String creator, @RequestParam(value="cVersion")String cVersion){
        Lenguaje lenguaje = new Lenguaje(name, creator, cVersion);
        return lServicio.creatLenguaje(lenguaje);
    }

    @GetMapping("/api/languages/{id}")
    public Lenguaje show(@PathVariable("id")Long id){
        Lenguaje lenguaje = lServicio.findLenguaje(id);
        return lenguaje;
    }
    
    @PutMapping("/api/languages/{id}")
    public Lenguaje update(@PathVariable("id") Long id, 
                        @RequestParam(value="name")String name, 
                        @RequestParam(value="creator")String creator, 
                        @RequestParam(value="currentVersion")String currentversion){
            Lenguaje lenguaje = lServicio.updatLenguaje(id, name, creator, currentversion);
            return lServicio.updateLenguaje(lenguaje);
    }

    @DeleteMapping("/api/languages/{id}")
    public void destroy(@PathVariable("id")Long id){
        lServicio.deleteLenguaje(id);
    }
}


