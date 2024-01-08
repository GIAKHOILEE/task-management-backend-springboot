package com.example.taskmanager.controller.messageGptController;


import com.example.taskmanager.DTO.messGptRequestDTO.ChatGPTRequest;
import com.example.taskmanager.DTO.messGptRequestDTO.ChatGptResponse;
import com.example.taskmanager.DTO.messGptRequestDTO.ChatRequestDto;
import com.example.taskmanager.entity.messageGptEntity.MessageGptEntity;
import com.example.taskmanager.service.messageGptService.MessageGptService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@CrossOrigin
@RequiredArgsConstructor
@RestController
@RequestMapping("/bot")
public class CustomBotController {

    @Value("${openai.model}")
    private String model;

    @Value(("${openai.api.url}"))
    private String apiURL;

    @Autowired
    private RestTemplate template;

    private final MessageGptService messageGptService;

    @PostMapping("/chat")
    public String chat(@RequestBody ChatRequestDto chatRequest){
        Long userId = chatRequest.getUserId();
        String prompt = chatRequest.getPrompt();
        ChatGPTRequest request=new ChatGPTRequest(model, prompt);
        ChatGptResponse chatGptResponse = template.postForObject(apiURL, request, ChatGptResponse.class);

        String gptResponse = chatGptResponse.getChoices().get(0).getMessage().getContent();
        messageGptService.saveMessage(userId, prompt, gptResponse);

        return gptResponse;
    }

    @GetMapping("/user/{userId}")
    public List<MessageGptEntity> getMessagesByUserId(@PathVariable Long userId) {
        return messageGptService.getMessagesByUserId(userId);
    }
}