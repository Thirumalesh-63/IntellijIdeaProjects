package com.example.Hello.Controller;

import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("greet")
public class HelloController {


    @GetMapping("/get")
    public String greetings(){
        return "hello";
    }
}
