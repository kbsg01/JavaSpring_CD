package com.kb.listaestudiantes.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.kb.listaestudiantes.models.Student;
import com.kb.listaestudiantes.repositories.StudentRepository;

@Service
public class StudentService {
    private final StudentRepository studentRepo;

    public StudentService(StudentRepository studentRepo) {
        this.studentRepo = studentRepo;
    }

    public List<Student> allStudents(){
        return studentRepo.findAll();
    }

    public Student createStudent(Student student){
        return studentRepo.save(student);
    }

    public Student findStudent(Long id){
        Optional<Student> opStudent = studentRepo.findById(id);
        if (opStudent.isPresent()) {
            return opStudent.get();
        } else {
            return null;
        }
    }
}
