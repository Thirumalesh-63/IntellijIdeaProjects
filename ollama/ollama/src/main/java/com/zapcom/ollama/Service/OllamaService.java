package com.zapcom.ollama.Service;


import org.springframework.ai.chat.model.ChatResponse;
import org.springframework.ai.chat.prompt.Prompt;
import org.springframework.ai.ollama.OllamaChatModel;
import org.springframework.ai.ollama.api.OllamaModel;
import org.springframework.ai.ollama.api.OllamaOptions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OllamaService {


    @Autowired
    private OllamaChatModel chatModel;


    public String generatePrompt(String prompt){
        ChatResponse response = chatModel.call(
                new Prompt(
                        prompt,
                        OllamaOptions.builder()
                                .withModel("llama2")
                                .build()
                ));

        return response.getResult().getOutput().getContent();
    }



}
