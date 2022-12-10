package com.kb.listaestudiantes.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.kb.listaestudiantes.models.Contact;

@Repository
public interface ContactRepository extends CrudRepository<Contact, Long>{
    List<Contact> findAll();
}
