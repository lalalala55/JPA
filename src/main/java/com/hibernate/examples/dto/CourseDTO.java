package com.hibernate.examples.dto;

public class CourseDTO {
    private String courseName;
    private Double courseFee;

    public CourseDTO() { super(); }

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
}
