package com.hibernate.examples;

import com.hibernate.examples.modal.Course;
import com.hibernate.examples.modal.Student;
import com.hibernate.examples.repository.CourseRepo;
import com.hibernate.examples.repository.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ExamplesApplication implements CommandLineRunner {

	@Autowired
	private StudentRepo studentRepo;

	@Autowired
	private CourseRepo courseRepo;

	public static void main(String[] args) {
		SpringApplication.run(ExamplesApplication.class, args);
	}


	@Override
	public void run(String... args) throws Exception {
		Student s1 = new Student();
		s1.setFirstname("raju");
		s1.setLastname("danger");

		Course c1 = new Course();
		c1.setCourseName("course 1");
		c1.setCourseFee(200.0);

		s1.add_course(c1);

		courseRepo.save(c1);
		studentRepo.save(s1);
	}
}
