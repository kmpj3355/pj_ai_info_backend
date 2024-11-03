package com.thxforservice.openapi.controllers;


import com.thxforservice.openapi.services.KoGptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/api/chat")
public class ChatController {


    private final KoGptService openAiService;

    @Autowired
    public ChatController(KoGptService openAiService) {
        this.openAiService = openAiService;
    }

    @PostMapping
    public String getChatResponse(@RequestBody Map<String, String> request) {
        String message = request.get("message");
        return openAiService.getChatResponse(message);
    }
}
