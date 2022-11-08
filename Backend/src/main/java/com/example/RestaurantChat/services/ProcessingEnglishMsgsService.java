package com.example.RestaurantChat.services;

import com.example.RestaurantChat.Lemmatization.Lemmatization;
import com.example.RestaurantChat.categorizerModelTraining.CategorizerModelTraining;
import com.example.RestaurantChat.categoryDetection.CategoryDetection;
import com.example.RestaurantChat.languageDetection.LanguageDetector;
import com.example.RestaurantChat.posTagsDetection.PostTagsDetection;
import com.example.RestaurantChat.sentenceDetection.SentenceDetection;
import com.example.RestaurantChat.tokenization.Tokenizing;
import opennlp.tools.doccat.DoccatModel;

import java.io.IOException;

public class ProcessingEnglishMsgsService {
    private CategoryDetection categoryDetection = new CategoryDetection();
    private Lemmatization lemmatization = new Lemmatization();
    private Tokenizing tokenizing = new Tokenizing();
    private PostTagsDetection postTagsDetection = new PostTagsDetection();

    public String processEnglishMsgs(String sentence, DoccatModel model) throws IOException {

        // Separate words from each sentence using tokenizer.
        String[] tokens = tokenizing.tokenizeSentence(sentence);

        // Tag separated words with POS tags to understand their gramatical structure.
        String[] posTags = postTagsDetection.detectPOSTags(tokens);

        // Lemmatize each word so that its easy to categorize.
        String[] lemmas = lemmatization.lemmatizeTokens(tokens, posTags);

        // Determine category using lemmatized tokens used a mode that we trained
        // at start.
        String category = categoryDetection.detectCategory(model, lemmas);

        return category;

    }


}
