package com.hibernate.examples.controller;

import com.hibernate.examples.modal.Course;
import com.hibernate.examples.modal.Student;
import com.hibernate.examples.repository.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/api/student")
public class StudentController {

    @Autowired
    private StudentRepo studentRepo;

    @PostMapping("")
    public Student saveStudent(@RequestBody Student student){
        return studentRepo.save(student);
    }

    @GetMapping("")
    public List<Student> getAllStudents(){
        Student s1 = new Student();
        s1.setFirstname("raju");
        s1.setLastname("ganga");

        Course c1 = new Course();
        c1.setCourseName("course 1");
        c1.setCourseFee(100.91);

        Course c2 = new Course();
        c2.setCourseName("course 2");
        c2.setCourseFee(100.9);

        s1.add_course(c1);
        s1.add_course(c2);

        studentRepo.save(s1);

        return studentRepo.findAll();
    }
}
