package com.hibernate.examples.modal;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

@Entity
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer courseId;
    private String courseName;
    private Double courseFee;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "student_id")
    @JsonIgnore
    private Student student;

    public Course() {
        super();
    }

    public Course(Integer courseId, String courseName, Double courseFee, Student student) {
        this.courseId = courseId;
        this.courseName = courseName;
        this.courseFee = courseFee;
        this.student = student;
    }

    public Integer getCourseId() {
        return courseId;
    }

    public void setCourseId(Integer courseId) {
        this.courseId = courseId;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public Double getCourseFee() {
        return courseFee;
    }

    public void setCourseFee(Double courseFee) {
        this.courseFee = courseFee;
    }

    public Student getstudent() {
        return student;
    }

    public void setstudent(Student student) {
        this.student = student;
    }

    @Override
    public String toString() {
        return "Course{" +
                "courseId=" + courseId +
                ", courseName='" + courseName + '\'' +
                ", courseFee=" + courseFee +
                ", student=" + student +
                '}';
    }
}
