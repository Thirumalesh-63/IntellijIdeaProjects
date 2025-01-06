package com.example.api_gateway.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {


    @GetMapping("/hi")
    public String greet(){
        return "hi";
    }
}
