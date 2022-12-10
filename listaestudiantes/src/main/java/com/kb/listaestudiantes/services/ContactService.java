package com.kb.listaestudiantes.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.kb.listaestudiantes.models.Contact;
import com.kb.listaestudiantes.repositories.ContactRepository;

@Service
public class ContactService {
    private final ContactRepository contactRepo;

    public ContactService(ContactRepository contactRepo) {
        this.contactRepo = contactRepo;
    }

    public List<Contact> allContacts(){
        return contactRepo.findAll();
    }

    public Contact createContact(Contact contact){
        return contactRepo.save(contact);
    }

    public Contact findContact(Long id){
        Optional<Contact> opContact = contactRepo.findById(id);
        if (opContact.isPresent()) {
            return opContact.get();
        } else {
            return null;
        }
    }
}
