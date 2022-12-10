package com.kb.dojosyninjas.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.kb.dojosyninjas.models.Dojo;
import com.kb.dojosyninjas.repositories.DojoRepository;

@Service
public class DojoService {
    private final DojoRepository dojoRepo;

    public DojoService(DojoRepository dojoRepo) {
        this.dojoRepo = dojoRepo;
    }

    public List<Dojo> allDojos(){
        return dojoRepo.findAll();
    }

    public Dojo createDojo(Dojo dojo){
        return dojoRepo.save(dojo);
    }

    public Dojo findDojo(Long id){
        Optional<Dojo> opDojo = dojoRepo.findById(id);
        if (opDojo.isPresent()) {
            return opDojo.get();
        } else {
            return null;
        }
    }
}
