package com.hibernate.examples.modal;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "student_")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String firstname;
    private String lastname;

    @ManyToMany
    @JoinTable(
            name="student_course",
            joinColumns = {@JoinColumn(name="student_id")},
            inverseJoinColumns = {@JoinColumn(name="course_id")}
    )
    private Set<Course> courses = new HashSet<>();

    public Student() {
      super();
    }

    public Student(Integer id, String firstname, String lastname,  Set<Course> courses) {
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

    public Set<Course> getCourses() {
        return courses;
    }

    public void setCourses(Set<Course> courses) {
        this.courses = courses;
    }

    public void add_course(Course course) {
        this.courses.add(course);
        course.getStudents().add(this);
    }

    public void remove_course(Course course) {
        this.courses.remove(course);
        course.getStudents().remove(this);
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
