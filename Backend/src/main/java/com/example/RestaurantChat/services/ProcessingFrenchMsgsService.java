package com.example.RestaurantChat.services;

import com.example.RestaurantChat.Lemmatization.Lemmatization;
import com.example.RestaurantChat.categorizerModelTraining.CategorizerModelTraining;
import com.example.RestaurantChat.categoryDetection.CategoryDetection;
import com.example.RestaurantChat.posTagsDetection.PostTagsDetection;
import com.example.RestaurantChat.tokenization.Tokenizing;
import opennlp.tools.doccat.DoccatModel;

import java.io.IOException;

public class ProcessingFrenchMsgsService {
    private CategoryDetection categoryDetection = new CategoryDetection();
    private Lemmatization lemmatization = new Lemmatization();
    private Tokenizing tokenizing = new Tokenizing();
    private PostTagsDetection postTagsDetection = new PostTagsDetection();
    private CategorizerModelTraining categorizerModelTraining = new CategorizerModelTraining();

    public String processFrenchMsgs(String sentence) throws IOException {

        // Train categorizer model to the training data we created.
        DoccatModel modelFr = categorizerModelTraining.trainCategorizerModelFr();

        // Separate words from each sentence using tokenizer.
        String[] tokens = tokenizing.tokenizeSentenceFr(sentence);

        // Tag separated words with POS tags to understand their gramatical structure.
        String[] posTags = postTagsDetection.detectPOSTagsFr(tokens);

        // Lemmatize each word so that its easy to categorize.
        String[] lemmas = lemmatization.lemmatizeTokens(tokens, posTags);

        // Determine category using lemmatized tokens used a mode that we trained
        // at start.
        return categoryDetection.detectCategory(modelFr, lemmas);

    }
}
