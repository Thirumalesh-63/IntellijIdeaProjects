package com.example.Hello.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

    @GetMapping("/greet")
    public String greetings(){
        return "Good morning";
    }
}
