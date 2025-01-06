package com.example.gradle.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {


    @GetMapping("/greet")
    public String greetings(){
        return "good morning";
    }
}
