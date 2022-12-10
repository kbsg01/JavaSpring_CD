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
public class StudentController {
    private final StudentService studentService;
    private final ContactService contactService;
    public StudentController(StudentService studentService, ContactService contactService) {
        this.studentService = studentService;
        this.contactService = contactService;
    }

    @GetMapping("/students")
    public String index(Model model){
        List<Student> students = studentService.allStudents();
        List<Contact> contacts = contactService.allContacts();
        model.addAttribute("contact", contacts);
        model.addAttribute("students", students);
        return "index";
    }

    @GetMapping("/students/new")
        public String createStudent(@ModelAttribute("student")Student student){
            return "newStudent"; 
            // muestra el formulario
        }
    
    @PostMapping("/students/new")
        public String createStudent(@Valid @ModelAttribute("student") Student student, BindingResult result, Model model){
            if (result.hasErrors()) {
                return "/students/new";
            } else {
                studentService.createStudent(student);
                return "redirect:/students";
            }
        }
}
