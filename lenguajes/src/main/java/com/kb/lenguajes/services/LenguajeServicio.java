package com.kb.lenguajes.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.kb.lenguajes.models.Lenguaje;
import com.kb.lenguajes.repositories.LenguajeRepositorio;

@Service
public class LenguajeServicio {
    private final LenguajeRepositorio lengRepo;

    public LenguajeServicio(LenguajeRepositorio lengRepo) {
        this.lengRepo = lengRepo;
    }

    // Lista todos los lenguajes
    public List<Lenguaje> allLenguajes(){
        return lengRepo.findAll();
    }

    // Crea un Lenguaje
    public Lenguaje creatLenguaje(Lenguaje lenguaje){
        return lengRepo.save(lenguaje);
    }

    // encuentra un Lenguaje por medio de la ID
    public Lenguaje findLenguaje(Long id){
        Optional<Lenguaje> optionalLenguaje = lengRepo.findById(id);
        if (optionalLenguaje.isPresent()) {
            return optionalLenguaje.get();
        } else {
            return null;
        }
    }

    // Actualiza un Lenguaje
    public Lenguaje updatLenguaje(Long id, String name, String creator, String currentVersion){
        Lenguaje toUpdate = lengRepo.findById(id).orElse(null);
        if (toUpdate == null) {
            return null;
        }
        toUpdate.setName(name);
        toUpdate.setCreator(creator);
        toUpdate.setCurrentVersion(currentVersion);

        return lengRepo.save(toUpdate);
    }

    public Lenguaje updateLenguaje(Lenguaje lenguaje){
        return lengRepo.save(lenguaje);
    }

    // Elimina un Lenguaje por medio de la ID
    public void deleteLenguaje(Long id){
        Lenguaje lenguaje = findLenguaje(id);
        if (lenguaje != null) {
            lengRepo.deleteById(id);
        }
    }
}
