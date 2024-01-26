package com.nwesseli.c322spring2024lab3.controllers;

import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

    @GetMapping("/")
    public String greetings(){
        return "Welcome to the animal service";
    }

}
