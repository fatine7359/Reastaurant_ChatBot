package com.example.RestaurantChat.services;

import com.example.RestaurantChat.Lemmatization.Lemmatization;
import com.example.RestaurantChat.categorizerModelTraining.CategorizerModelTraining;
import com.example.RestaurantChat.categoryDetection.CategoryDetection;
import com.example.RestaurantChat.languageDetection.LanguageDetector;
import com.example.RestaurantChat.models.Message;
import com.example.RestaurantChat.openNlpOperations.OpenNlpOperations;
import com.example.RestaurantChat.openNlpOperations.OpenNlpOperationsFrench;
import com.example.RestaurantChat.posTagsDetection.PostTagsDetection;
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

    /*
     * Define answers for each given category.
     */
    static {
        questionAnswer.put("greeting", "Hello, how can I help you?");
        questionAnswer.put("menu-inquiry",
                "for the menu whe have:\n" +
                        "as appetizers: Guacamole, Balsamic Bruschetta, Hot Spinach Artichoke Dip.\n" +
                        "as main dishes: Cedar-Plank Salmon, Seared Scallops With Brown Butter and Lemon Pan Sauce.\n" +
                        "as dessert: Chocolate Raspberry Mousse, BrowniesChocolate, Cheesecake.\n");
        questionAnswer.put("price-inquiry", "appetizers: 20$ -- 25$\n" +
                "main dish: 25$ -- 70$\n" +
                "dessert: 30$ -- 50$\n");
        questionAnswer.put("conversation-continue", "What else can I help you with?");
        questionAnswer.put("conversation-complete", "Nice chatting with you. Bbye.");

    }

    static {
        questionAnswerFr.put("greeting", "Hey, Comment je peux vous aider?");
        questionAnswerFr.put("menu-inquiry",
                "Pour le menu on a:\n" +
                        "Comme entrée: Guacamole, Velouté potimarron et lait d'amande, Oeufs mollets champignons bacon.\n" +
                        "Comme plat principal: Blanquette de veau, Lasagnes à la bolognaise, Courge spaghetti à la crème et aux lardons.\n" +
                        "Comme dessert: Mousse au Chocolate et au Raspberry , Brownies au Chocolat, Cheesecake.\n");
        questionAnswerFr.put("price-inquiry", "entrée: 20$ -- 25$\n" +
                "plat principal: 25$ -- 70$\n" +
                "dessert: 30$ -- 50$\n");
        questionAnswerFr.put("conversation-continue", "Comment je peux vous aider d'avantage?");
        questionAnswerFr.put("conversation-complete", "Ravi de communiquer avec vous.");

    }




    public Message processMsg(Message message) throws IOException, InterruptedException {

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
