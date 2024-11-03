package com.thxforservice.openapi.openai;

import com.thxforservice.openapi.openai.dto.HuggingFaceRequest;
import com.thxforservice.openapi.openai.dto.HuggingFaceResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class KoGptClient {


    @Value("${huggingface.api.key}")
    private String huggingFaceApiKey;

    private final RestTemplate restTemplate = new RestTemplate();
    private final String HUGGING_FACE_API_URL = "https://api-inference.huggingface.co/models/skt/ko-gpt-trinity-1.2B-v0.5";

    public String getChatResponse(String message) {
        // HuggingFaceRequest 객체 생성
        HuggingFaceRequest requestBody = new HuggingFaceRequest(message);

        // HTTP 요청 헤더 설정
        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", "Bearer " + huggingFaceApiKey);
        headers.set("Content-Type", "application/json");

        // HttpEntity로 HuggingFaceRequest와 헤더를 감싸서 보냄
        HttpEntity<HuggingFaceRequest> requestEntity = new HttpEntity<>(requestBody, headers);

        // Hugging Face API 호출 및 응답 처리
        ResponseEntity<HuggingFaceResponse[]> responseEntity = restTemplate.exchange(
                HUGGING_FACE_API_URL,
                HttpMethod.POST,
                requestEntity,
                HuggingFaceResponse[].class
        );

        // HuggingFaceResponse에서 생성된 텍스트 추출
        HuggingFaceResponse[] responseBody = responseEntity.getBody();
        if (responseBody != null && responseBody.length > 0) {
            return responseBody[0].getGeneratedText();
        } else {
            return "응답이 올바르지 않습니다.";
        }
    }
}
