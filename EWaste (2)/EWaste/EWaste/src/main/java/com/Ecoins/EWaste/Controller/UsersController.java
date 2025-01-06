package com.Ecoins.EWaste.Controller;


import com.Ecoins.EWaste.Model.UserDetails;
import com.Ecoins.EWaste.Service.Service1;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("*")
public class UsersController {


    @Autowired
    private Service1 service1;

    @GetMapping("hi")
    public String greetings(){
        return "hello";
    }


    @PostMapping("/userdetails")
    public void saveUsers(){

        String jsonLiteral="{ \"identityData\": { \"userId\": \"456\", \"userCreatedTime\": \"2023-10-01\", \"lastModifiedTime\": \"2023-10-12\" } }";

        service1.upsertUserDetails(jsonLiteral);
    }
    @GetMapping("userdetails")
    public UserDetails getUser(){
        return service1.getUser();
    }
    @PostMapping("/userdetails2")
    public void saveUsers(@RequestBody UserDetails userDetails){

     System.err.println(userDetails.getUSER_ID());
        service1.upsertUserDetails2(userDetails);
    }

}