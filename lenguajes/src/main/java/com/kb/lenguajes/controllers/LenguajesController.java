package com.kb.lenguajes.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.kb.lenguajes.models.Lenguaje;
import com.kb.lenguajes.services.LenguajeServicio;

@Controller
public class LenguajesController {
    private final LenguajeServicio lServicio;

    public LenguajesController(LenguajeServicio lServicio) {
        this.lServicio = lServicio;
    }

    @GetMapping("/languages")
    public String index(@ModelAttribute("lenguaje") Lenguaje lenguaje, Model model){
        List<Lenguaje> lenguajes = lServicio.allLenguajes();
        model.addAttribute("lenguajes", lenguajes);
        return "/lenguajes/index";
    }

    @PostMapping("/languages")
    public String create(@Valid @ModelAttribute("lenguaje") Lenguaje lenguaje, BindingResult result){
        if (result.hasErrors()) {
            return"";
        } else {
            lServicio.creatLenguaje(lenguaje);
            return "redirect:/languages";
        }
    }

    @GetMapping("/languages/{id}")
    public String show(@PathVariable("id")Long id, Model model){
        Lenguaje lenguaje = lServicio.findLenguaje(id);
        model.addAttribute("lenguaje", lenguaje);
        return "/lenguajes/show";
    }

    @GetMapping("/languages/{id}/edit")
    public String edit(@PathVariable("id")Long id, Model model){
        Lenguaje lenguaje = lServicio.findLenguaje(id);
        model.addAttribute("lenguaje", lenguaje);
        return "/lenguajes/edit";
    }

    @PutMapping("/languages/{id}")
    public String update(@Valid @ModelAttribute("lenguje") Lenguaje lenguaje, BindingResult result){
        if (result.hasErrors()) {
            return "/lenguajes/edit";
        } else{
            lServicio.updateLenguaje(lenguaje);
            return "redirect:/languages";
        }
    }

    @RequestMapping("/languages/{id}/delete")
    public String delete(@PathVariable("id")Long id){
        lServicio.deleteLenguaje(id);
        return "redirect:/languages";
    }
}
