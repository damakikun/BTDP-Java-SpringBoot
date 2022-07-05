package com.example.api.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/belajar-api/v1")
public class BelajarAPIController {
    @GetMapping(value = "/get")
    public String belajarAPI(){
        return "Woops! You hit the API";
    }
}