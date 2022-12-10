package com.kb.listaestudiantes.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.kb.listaestudiantes.models.Contact;
import com.kb.listaestudiantes.models.Student;
import com.kb.listaestudiantes.services.ContactService;
import com.kb.listaestudiantes.services.StudentService;

@Controller
public class ContactController {

    private final ContactService contactService;
    private final StudentService studentService;

    public ContactController(ContactService contactService, StudentService studentService) {
        this.contactService = contactService;
        this.studentService = studentService;
    }

    @GetMapping("/contact/new")
    public String addContact(@ModelAttribute("contact")Contact contact, Model model){
        List<Student> students = studentService.allStudents();
        model.addAttribute("students", students);
        return "newContact";
    }

    @PostMapping("contact/new")
    public String addContact(@Valid @ModelAttribute("contact")Contact contact, BindingResult result){
        if (result.hasErrors()) {
            return "newContact";
        } else {
            contactService.createContact(contact);
            return "redirect:/students";
        }
    }
}
