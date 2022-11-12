package com.example.RestaurantChat.services;

import com.example.RestaurantChat.Lemmatization.Lemmatization;
import com.example.RestaurantChat.categorizerModelTraining.CategorizerModelTraining;
import com.example.RestaurantChat.categoryDetection.CategoryDetection;
import com.example.RestaurantChat.languageDetection.LanguageDetector;
import com.example.RestaurantChat.posTagsDetection.PostTagsDetection;
import com.example.RestaurantChat.sentenceDetection.SentenceDetection;
import com.example.RestaurantChat.tokenization.Tokenizing;
import opennlp.tools.doccat.DoccatModel;
import org.springframework.stereotype.Service;

import java.io.IOException;

public class ProcessingEnglishMsgsService implements ProcessingLanguageMsgsService{
    private CategoryDetection categoryDetection = new CategoryDetection();
    private Lemmatization lemmatization = new Lemmatization();
    private Tokenizing tokenizing = new Tokenizing();
    private PostTagsDetection postTagsDetection = new PostTagsDetection();
    private CategorizerModelTraining categorizerModelTraining = new CategorizerModelTraining();

    @Override
    public String processLanguageMsgs(String sentence) throws IOException {
        // Train categorizer model to the training data we created.
        DoccatModel model = categorizerModelTraining.trainCategorizerModel();

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
