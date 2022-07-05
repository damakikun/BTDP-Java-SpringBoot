package com.belajar.product.controller;

import java.util.List;

import com.belajar.product.entity.User;
import com.belajar.product.repository.UserRepository;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/management")
public class ManagementController {
	
    private UserRepository userRepository;

    public ManagementController(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    @GetMapping("/test1")
    public String test1(){
        return "API Test 1";
    }

    @GetMapping("/test2")
    public String test2(){
        return "API Test 2";
    }
    
    @GetMapping("")
    public List<User> users(){
        return this.userRepository.findAll();
    }

}