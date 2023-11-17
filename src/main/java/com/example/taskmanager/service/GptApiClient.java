package com.example.taskmanager.service;

import lombok.RequiredArgsConstructor;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@RequiredArgsConstructor
@Service
public class GptApiClient {
    private final String gptApiUrl = "https://api.openai.com/v1/completions"; // Thay thế bằng URL thực tế của GPT API
    private final String apiKey = "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";

    private final RestTemplate restTemplate;

    public GptApiClient() {
        this.restTemplate = new RestTemplate();
    }

    public String sendGptRequest(String userInput) {
        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", "Bearer " + apiKey);
        headers.set("Content-Type", "application/json");

        // Chuẩn bị dữ liệu để gửi đến GPT API
        String requestBody = "{\"input\": \"" + userInput + "\"}";

        HttpEntity<String> requestEntity = new HttpEntity<>(requestBody, headers);

        // Gọi GPT API và nhận câu trả lời
        ResponseEntity<String> responseEntity = restTemplate.exchange(gptApiUrl, HttpMethod.POST, requestEntity, String.class);

        // Lấy nội dung của câu trả lời
        String gptResponse = responseEntity.getBody();

        return gptResponse;
    }
}
