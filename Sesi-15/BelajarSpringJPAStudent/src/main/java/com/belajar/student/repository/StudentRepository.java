package com.belajar.student.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.belajar.student.model.Student;

public interface StudentRepository extends JpaRepository<Student, Long> {

}