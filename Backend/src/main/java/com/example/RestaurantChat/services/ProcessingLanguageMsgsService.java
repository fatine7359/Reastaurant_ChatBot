package com.example.RestaurantChat.services;

import org.springframework.stereotype.Service;

import java.io.IOException;

public interface ProcessingLanguageMsgsService {

    public String processLanguageMsgs(String sentence) throws IOException;
}
