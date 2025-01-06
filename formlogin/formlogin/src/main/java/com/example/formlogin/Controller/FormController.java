package com.example.formlogin.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
public class FormController {

    @GetMapping("/greet")
    public String greetings(){
        return "Good morning";
    }
    @GetMapping("/secured")
    public String login(){
        return "secured endpoint";
    }


}
