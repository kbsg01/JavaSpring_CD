package com.kb.dojosyninjas.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.kb.dojosyninjas.models.Ninja;
import com.kb.dojosyninjas.repositories.NinjaRepository;

@Service
public class NinjaService {
    private final NinjaRepository ninjaRepo;

    public NinjaService(NinjaRepository ninjaRepo) {
        this.ninjaRepo = ninjaRepo;
    }

    public List<Ninja> allNinjas(){
        return ninjaRepo.findAll();
    }

    public Ninja createNinja(Ninja ninja){
        return ninjaRepo.save(ninja);
    }

    public Ninja findNinja(Long id){
        Optional<Ninja> opNinja = ninjaRepo.findById(id);
        if (opNinja.isPresent()) {
            return opNinja.get();
        } else {
            return null;
        }
    }
}
