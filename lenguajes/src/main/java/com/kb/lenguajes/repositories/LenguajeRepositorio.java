package com.kb.lenguajes.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.kb.lenguajes.models.Lenguaje;
@Repository
public interface LenguajeRepositorio extends CrudRepository<Lenguaje, Long>{
    List<Lenguaje> findAll();
    List<Lenguaje> findByNameContaining(String search);
    Long countByNameContaining(String search);
    Long deleteByNameStartingWith(String search);
}
