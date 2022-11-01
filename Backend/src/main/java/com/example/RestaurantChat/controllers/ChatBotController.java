package com.example.RestaurantChat.controllers;

import com.example.RestaurantChat.ProcessMsg;
import com.example.RestaurantChat.models.Message;
import com.example.RestaurantChat.services.ProcessingMsgsService;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
@RequestMapping(path = "/chatbot")
@CrossOrigin(origins = "http://localhost:8080")
public class ChatBotController {

    private ProcessingMsgsService processingMsgsService;


    public ChatBotController(ProcessingMsgsService receivingMsgsService) {
        this.processingMsgsService = receivingMsgsService;
    }

    @PostMapping("/receive")
    public Message receiveMsg(@RequestBody Message message){
        try {
            return processingMsgsService.processMsg(message);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

}
