package com.example.taskmanager.handle;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Slf4j
public class MyHandler extends TextWebSocketHandler{
    @Override
    protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
        // Xử lý tin nhắn từ client và gửi lại tin nhắn phản hồi
        String clientMessage = message.getPayload();
        System.out.println("Received message from client: " + clientMessage);

        // Gửi tin nhắn phản hồi về client
        String serverMessage = "Hello, " + clientMessage + "!";
        session.sendMessage(new TextMessage(serverMessage));
    }
}
