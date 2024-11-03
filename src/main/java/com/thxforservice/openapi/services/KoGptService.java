package com.thxforservice.openapi.services;

import com.thxforservice.openapi.openai.KoGptClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class KoGptService {


    private final KoGptClient koGptClient;

    @Autowired
    public KoGptService(KoGptClient koGptClient) {
        this.koGptClient = koGptClient;
    }

    public String getChatResponse(String message) {
        return koGptClient.getChatResponse(message);
    }
}
