package com.hibernate.examples.controller;

import com.hibernate.examples.modal.Student;
import com.hibernate.examples.repository.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/student")
public class StudentController {

    @Autowired
    private StudentRepo studentRepo;

//    @PostMapping("")
//    public Student saveStudent(@RequestBody Student student){
//        return studentRepo.save(student);
//    }

    @GetMapping("")
    public List<Student> getAllStudents(){
        return studentRepo.findAll();
    }
}
