package com.thxforservice.openapi.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ChatService {

    private final KoGptService koGptService;

    @Autowired
    public ChatService(KoGptService koGptService) {
        this.koGptService = koGptService;
    }

    public String processChatMessage(String message) {
        // Hugging Face 모델을 통해 한국어 응답 생성
        String response = koGptService.getChatResponse(message);

        // 추가 비즈니스 로직 (필요시 추가)
        return "AI 응답: " + response;
    }
}
