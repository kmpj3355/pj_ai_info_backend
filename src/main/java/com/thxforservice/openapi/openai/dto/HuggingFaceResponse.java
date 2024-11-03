package com.thxforservice.openapi.openai.dto;


import lombok.Data;

@Data
public class HuggingFaceResponse {

    private String generated_text;

    public String getGeneratedText() {
        return generated_text;
    }

}
