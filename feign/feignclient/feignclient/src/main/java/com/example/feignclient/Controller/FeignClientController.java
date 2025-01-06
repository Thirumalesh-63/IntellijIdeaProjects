package com.example.feignclient.Controller;

import com.example.feignclient.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FeignClientController {


    @GetMapping("/greet")
    public User greetings(){
        User u=new User();
        u.setName("hari");
        u.setCity("kurnool");
        return u;
    }
}
