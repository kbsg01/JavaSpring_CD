package com.kb.driverslicenses.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.kb.driverslicenses.models.Person;
import com.kb.driverslicenses.services.LicensesService;
import com.kb.driverslicenses.services.PersonService;

@Controller
public class PersonController {
    private final PersonService personService;
    private final LicensesService licensesService;



    public PersonController(PersonService personService, LicensesService licensesService) {
        this.personService = personService;
        this.licensesService = licensesService;
    }

    @GetMapping("/persons/new")
    public String nPerson(@ModelAttribute("person")Person person){
        return "persons/new";
    }

    @PostMapping("persons/new")
    public String nPerson(@ModelAttribute("person")Person person, BindingResult result){
        if (result.hasErrors()) {
            return "persons/new";
        } else {
            personService.create(person);
            return "redirect:/persons/new";
        }
    }

    
    @GetMapping("/persons/{id}")
    public String showPerson(@PathVariable("id")Long id, Model model){
        model.addAttribute("person", personService.findPerson(id));
        model.addAttribute("license", licensesService.findLicense(id));
        return "persons/show";
    }

}
