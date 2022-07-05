package com.belajar.student;


import java.util.Arrays;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.belajar.student.model.Course;
import com.belajar.student.model.Student;
import com.belajar.student.repository.CourseRepository;
import com.belajar.student.repository.StudentRepository;

@SpringBootApplication
public class BelajarSpringJpaStudentApplication implements CommandLineRunner {
	
	private final Logger LOG = LoggerFactory.getLogger(BelajarSpringJpaStudentApplication.class);
	
	@Autowired
	private StudentRepository studentRepository;
	
	@Autowired
	private CourseRepository courseRepository;

	public static void main(String[] args) {
		SpringApplication.run(BelajarSpringJpaStudentApplication.class, args);
	}
	
	@Override
	public void run(String...args) throws Exception {
		// create a student
		Student student = new Student ("Adam Ghufron", 24);
		
		// save the student
		studentRepository.save(student);
		
		// create 3 courses
		Course course1 = new Course("Spring Boot Dasar", 4, 1000);
		Course course2 = new Course("Membuat Project Spring Boot untuk Pemula", 5, 2000);
		Course course3 = new Course("MySQL Dasar", 6, 1500);
		
		// save the courses
		courseRepository.saveAll(Arrays.asList(course1, course2, course3));
		
		// add courses to the student
		student.getCourses().addAll(Arrays.asList(course1, course2, course3));
		
		// update the student
		studentRepository.save(student);
		
		
		List<Student> students = studentRepository.findAll();
		LOG.info("Students:"+students);
		
		List<Course> courses = courseRepository.findAll();
		LOG.info("Courses:"+courses);
	}

}