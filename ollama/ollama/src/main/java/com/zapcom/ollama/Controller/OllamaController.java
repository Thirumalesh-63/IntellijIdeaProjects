package com.zapcom.ollama.Controller;


import com.zapcom.ollama.Service.OllamaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OllamaController {


    @Autowired
    private OllamaService service;

    @GetMapping("/ollama")
    public String generatePrompt(@RequestParam String prompt){
        return service.generatePrompt(prompt);
    }
}
