package com.zapcon.JPAMultidatabases.Controller;

import com.zapcon.JPAMultidatabases.Service.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {


    @Autowired
    private Service service;


    @GetMapping("/mdb")
    public String mdbs(){
        service.saveData();
        return "success";
    }

}
