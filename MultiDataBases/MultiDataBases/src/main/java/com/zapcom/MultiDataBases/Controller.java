package com.zapcom.MultiDataBases;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {


    @Autowired
    private Service1 service;


    @GetMapping("/h2")
    public String getAllFromH2() {
         service.h2database();
        return "complted";
    }
    @PostMapping("/sql")
    public String getAllFromsql(@RequestBody User user) {
        String response=service.sqldatabase(user);
        return response;
    }
}
