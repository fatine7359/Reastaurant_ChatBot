package com.example.RestaurantChat.Lemmatization;

import opennlp.tools.lemmatizer.LemmatizerME;
import opennlp.tools.lemmatizer.LemmatizerModel;
import opennlp.tools.util.InvalidFormatException;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.stream.Collectors;

public class Lemmatization {

    public String[] lemmatizeTokens(String[] tokens, String[] posTags)
            throws InvalidFormatException, IOException {
        // Better to read file once at start of program & store model in instance
        // variable. but keeping here for simplicity in understanding.
        try (InputStream modelIn = new FileInputStream("en-lemmatizer.bin")) {

            // Tag sentence.
            LemmatizerME myCategorizer = new LemmatizerME(new LemmatizerModel(modelIn));
            String[] lemmaTokens = myCategorizer.lemmatize(tokens, posTags);
            System.out.println("Lemmatizer : " + Arrays.stream(lemmaTokens).collect(Collectors.joining(" | ")));

            return lemmaTokens;

        }
    }

    public String[] lemmatizeTokensFr(String[] tokens, String[] posTags)
            throws InvalidFormatException, IOException {
        // Better to read file once at start of program & store model in instance
        // variable. but keeping here for simplicity in understanding.
        try (InputStream modelIn = new FileInputStream("en-lemmatizer.bin")) {

            // Tag sentence.
            LemmatizerME myCategorizer = new LemmatizerME(new LemmatizerModel(modelIn));
            String[] lemmaTokens = myCategorizer.lemmatize(tokens, posTags);
            System.out.println("Lemmatizer : " + Arrays.stream(lemmaTokens).collect(Collectors.joining(" | ")));

            return lemmaTokens;

        }
    }


}
