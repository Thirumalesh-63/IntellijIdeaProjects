package com.zapcom.mapstruct.Controller;

import com.zapcom.mapstruct.mapper.MyMapper;
import com.zapcom.mapstruct.model.Student;
import com.zapcom.mapstruct.model.StudentMapper;
import com.zapcom.mapstruct.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

    @Autowired
    public MyMapper mapper;

    @GetMapping("mapstruct")
    public void mapstruct(){
        Student std=new Student(1,"hari",23,"A");
        User user=new User();
        System.err.println(std);
        mapper.sourceToData(std,user);
         StudentMapper mapper2= mapper.mapExtraFields(std);

         System.err.println(user.getName());
        System.err.println(mapper2.getExtraFields());
    }
}
