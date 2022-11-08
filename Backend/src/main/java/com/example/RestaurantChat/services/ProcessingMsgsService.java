package com.example.RestaurantChat.services;

import com.example.RestaurantChat.Lemmatization.Lemmatization;
import com.example.RestaurantChat.categorizerModelTraining.CategorizerModelTraining;
import com.example.RestaurantChat.categoryDetection.CategoryDetection;
import com.example.RestaurantChat.languageDetection.LanguageDetector;
import com.example.RestaurantChat.models.Message;

import com.example.RestaurantChat.sentenceDetection.SentenceDetection;
import com.example.RestaurantChat.tokenization.Tokenizing;
import opennlp.tools.doccat.DoccatModel;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@Service
public class ProcessingMsgsService {

    private CategorizerModelTraining categorizerModelTraining = new CategorizerModelTraining();
    private SentenceDetection sentenceDetection = new SentenceDetection();
    private LanguageDetector languageDetector = new LanguageDetector();

    private ProcessingEnglishMsgsService processingEnglishMsgsService = new ProcessingEnglishMsgsService();
    private ProcessingFrenchMsgsService processingFrenchMsgsService = new ProcessingFrenchMsgsService();
    private static Map<String, String> questionAnswer = new HashMap<>();
    private static Map<String, String> questionAnswerFr = new HashMap<>();

    private InitializeEnglishAnswers initializeEnglishAnswers = new InitializeEnglishAnswers();
    
    public Message processMsg(Message message) throws IOException, InterruptedException {

        initializeEnglishAnswers.initializeAnswers(questionAnswer);
        initializeEnglishAnswers.initializeFrAnswers(questionAnswerFr);

        //Prepare the response: Message Object
        Message chatBotResponse = new Message();
        chatBotResponse.setDate(message.getDate());
        chatBotResponse.setOwner(false);

        //Prepare the text property of the response
        String answer = "";

        // Train categorizer model to the training data we created.
        DoccatModel model = categorizerModelTraining.trainCategorizerModel();

        // Take chat inputs from message variable sent by frontend.
        String userInput = message.getText();

        // Break users chat input into sentences using sentence detection.
        String[] sentences = sentenceDetection.breakSentences(userInput);

        //Detect language of the user
        String lang = languageDetector.detectLanguage(sentences[0]);

        // Loop through sentences.
        for (String sentence : sentences) {

            if (lang.equals("English")) {
                String category = processingEnglishMsgsService.processEnglishMsgs(sentence, model);
                // Get predefined answer from given category & add to answer.
                answer = answer + " " + questionAnswer.get(category);
            }

            if(lang.equals("French")){
                String category = processingFrenchMsgsService.processFrenchMsgs(sentence);
                // Get predefined answer from given category & add to answer.
                answer = answer + " " + questionAnswerFr.get(category);
            }
        }

        //Set the text of the message with answer from chatBot
        chatBotResponse.setText(answer);

        return chatBotResponse;
    }
}
