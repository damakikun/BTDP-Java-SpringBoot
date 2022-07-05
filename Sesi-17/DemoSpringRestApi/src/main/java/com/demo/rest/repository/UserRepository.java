package com.demo.rest.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.demo.rest.model.User;

public interface UserRepository extends JpaRepository<User, Integer> {
	
}