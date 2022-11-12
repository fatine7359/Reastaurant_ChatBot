package com.example.RestaurantChat.services;

import java.util.Map;

public class InitializeEnglishAnswers {

    public void initializeAnswers(Map<String, String> questionAnswer){

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
        questionAnswer.put("conversation-complete", "Nice chatting with you. Bye.");

    }

    public void initializeFrAnswers(Map<String, String> questionAnswerFr){

        questionAnswerFr.put("greeting", "Salut, Comment je peux vous aider?");
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
}
