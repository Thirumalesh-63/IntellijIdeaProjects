package com.example.feignclient2.Controller;

import com.example.feignclient2.User;
import com.example.feignclient2.feign.MyFeign;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FeignClient2Controller {

    @Autowired
    private MyFeign myFeign;

    @GetMapping("/get")
    public String get(){
       User u= myFeign.greet();
       return "welcome " + u.getName();
    }
}
