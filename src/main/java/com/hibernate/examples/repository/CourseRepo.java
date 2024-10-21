package com.hibernate.examples.repository;

import com.hibernate.examples.modal.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepo extends JpaRepository<Course, Integer> {
}
