package com.belajar.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.belajar.spring.model.Book;

public interface BookRepository extends JpaRepository<Book, Long> {

}