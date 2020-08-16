package dev.ddiffa.springsocket.controller;

import dev.ddiffa.springsocket.model.SocketMessage;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessageHeaderAccessor;
import org.springframework.stereotype.Controller;

@Controller
public class SocketMessageController {

    @MessageMapping("/chat.register")
    @SendTo("/topic/public")
    public SocketMessage register(@Payload SocketMessage socketMessage, SimpMessageHeaderAccessor headerAccessor){
        headerAccessor.getSessionAttributes().put("username", socketMessage.getSender());
        System.out.println("masok");
        return socketMessage;
    }

    @MessageMapping("chat.send")
    @SendTo("/topic/public")
    public SocketMessage sendMessage(@Payload SocketMessage socketMessage){
        System.out.println("send");
        return socketMessage;
    }
}
