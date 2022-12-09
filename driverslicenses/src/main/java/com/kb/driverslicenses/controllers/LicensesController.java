package com.kb.driverslicenses.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.kb.driverslicenses.models.License;
import com.kb.driverslicenses.models.Person;
import com.kb.driverslicenses.services.LicensesService;
import com.kb.driverslicenses.services.PersonService;

@Controller
public class LicensesController {
    private final LicensesService licenseService;
    private final PersonService personService;

    public LicensesController(LicensesService licenseService, PersonService personService) {
        this.licenseService = licenseService;
        this.personService = personService;
    }

    @GetMapping("/licenses/new")
    public String nLicense(@ModelAttribute("license")License license, Model model){
        List<Person> persons = personService.allPerson();
        model.addAttribute("persons", persons);
        return "licenses/new";
    }

    @PostMapping("/licenses/new")
    public String nlicence(@Valid @ModelAttribute("license")License license, BindingResult result, Model model){
        System.out.println(license.getNumber());
        System.out.println(license.getExpirationDate());
        if(result.hasErrors()){
            return "licenses/new";
        } else {
            license.numeroLicencia();
            licenseService.create(license);
            return "redirect:/licenses/new";
        }
    }

}
