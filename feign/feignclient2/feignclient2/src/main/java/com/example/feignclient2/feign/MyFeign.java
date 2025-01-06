package com.example.feignclient2.feign;


import com.example.feignclient2.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "myFeign", url = "http://localhost:8080")
public interface MyFeign {

    @GetMapping("/greet")
    User greet();


}
