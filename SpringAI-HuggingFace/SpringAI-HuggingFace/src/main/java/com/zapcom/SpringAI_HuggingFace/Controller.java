package com.zapcom.SpringAI_HuggingFace;

import org.springframework.ai.huggingface.HuggingfaceChatModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class Controller {
    private final HuggingfaceChatModel chatModel;

    @Autowired
    public Controller(HuggingfaceChatModel chatModel) {
        this.chatModel = chatModel;
    }

    @GetMapping("/ai/chat")
    public Map<String, String> generate(@RequestParam(value = "message", defaultValue = "Tell me a joke") String message) {
        return Map.of("generation", this.chatModel.call(message));
    }
}