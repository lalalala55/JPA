package com.hibernate.examples.modal;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "student_")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String firstname;
    private String lastname;

    @OneToMany(mappedBy = "student", cascade = CascadeType.ALL)
    private List<Course> courses = new ArrayList<>();

    public Student() {
      super();
    }

    public Student(Integer id, String firstname, String lastname,  List<Course> courses) {
        this.id = id;
        this.firstname = firstname;
        this.lastname = lastname;
        this.courses = courses;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public List<Course> getCourses() {
        return courses;
    }

    public void setCourses(List<Course> courses) {
        this.courses = courses;
    }

    public void add_course(Course course) {
        this.courses.add(course);
        course.setstudent(this);
    }

    public void remove_course(Course course) {
        this.courses.remove(course);
        course.setstudent(null);
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", courses=" + courses +
                '}';
    }
}
