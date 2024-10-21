package com.hibernate.examples.controller;

import com.hibernate.examples.dto.CourseDTO;
import com.hibernate.examples.dto.StudentDTO;
import com.hibernate.examples.modal.Course;
import com.hibernate.examples.modal.Student;
import com.hibernate.examples.repository.CourseRepo;
import com.hibernate.examples.repository.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/student")
public class StudentController {

    @Autowired
    private StudentRepo studentRepo;

    @Autowired
    private CourseRepo courseRepo;

    @PostMapping("")
    public Student saveStudent(@RequestBody StudentDTO student){
        Student s1 = new Student();
        for(CourseDTO courseDTO: student.getCourses()) {
            Course c = new Course();
            c.setCourseName(courseDTO.getCourseName());
            c.setCourseFee(courseDTO.getCourseFee());
            s1.add_course(c);
            courseRepo.save(c); // to make the data persist
        }
        s1.setFirstname(student.getFirstname());
        s1.setLastname(student.getLastname());
        return studentRepo.save(s1);
    }

    @GetMapping("")
    public List<Student> getAllStudents(){
        return studentRepo.findAll();
    }
}
