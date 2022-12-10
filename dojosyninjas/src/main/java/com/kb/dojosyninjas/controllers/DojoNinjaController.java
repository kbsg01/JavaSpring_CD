package com.kb.dojosyninjas.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.kb.dojosyninjas.models.Dojo;
import com.kb.dojosyninjas.models.Ninja;
import com.kb.dojosyninjas.services.DojoService;
import com.kb.dojosyninjas.services.NinjaService;

@Controller
public class DojoNinjaController {
    private final DojoService dojoService;
    private final NinjaService ninjaService;

    public DojoNinjaController(DojoService dojoService, NinjaService ninjaService) {
        this.dojoService = dojoService;
        this.ninjaService = ninjaService;
    }

    @GetMapping("/dojos/new")
    public String nDojo(@ModelAttribute("dojo")Dojo dojo){
        return "newDojo";
    }

    @PostMapping("/dojos/new")
    public String nDojo(@Valid @ModelAttribute("dojo")Dojo dojo, BindingResult result){
        if (result.hasErrors()) {
            return "newDojo";
        } else {
            dojoService.createDojo(dojo);
            return "redirect:/dojos/new";
        }
    }

    @GetMapping("/ninjas/new")
    public String nNinja(@ModelAttribute("ninja")Ninja ninja, Model model){
        List<Dojo> dojos = dojoService.allDojos();
        model.addAttribute("dojos", dojos);
        return "newNinja";
    }

    @PostMapping("/ninjas/new")
    public String nNinja(@Valid @ModelAttribute("ninja")Ninja ninja, BindingResult result){
        if (result.hasErrors()) {
            return "newNinja";
        } else {
            ninjaService.createNinja(ninja);
            return "redirect:/ninjas/new";
        }
    }

    @GetMapping("/dojos/{id}")
    public String dojoInfo(@PathVariable("id")Long id, Model model){
        Dojo dojo = dojoService.findDojo(id);
        List<Ninja> ninjas = dojo.getNinjas();
        model.addAttribute("dojo", dojo);
        model.addAttribute("ninjas", ninjas);
        return "dojo";
    }
}
