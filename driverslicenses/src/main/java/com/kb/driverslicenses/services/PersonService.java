package com.kb.driverslicenses.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.kb.driverslicenses.models.Person;
import com.kb.driverslicenses.repositories.PersonRepository;

@Service
public class PersonService {
    private final PersonRepository personRepo;

    public PersonService(PersonRepository personRepo) {
        this.personRepo = personRepo;
    }

    public List<Person> allPerson(){
        return personRepo.findAll();
    }

    public Person create(Person person){
        return personRepo.save(person);
    }

    public Person findPerson(Long id){
        Optional<Person> optionalPerson = personRepo.findById(id);
        if(optionalPerson.isPresent()){
            return optionalPerson.get();
        } else {
            return null;
        }
    }
}
