package com.belajar.student.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.belajar.student.model.Course;

public interface CourseRepository extends JpaRepository<Course, Long> {

}