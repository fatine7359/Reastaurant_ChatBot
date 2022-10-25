package com.example.RestaurantChat.posTagsDetection;

import opennlp.tools.postag.POSModel;
import opennlp.tools.postag.POSTaggerME;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.stream.Collectors;

public class PostTagsDetection {

    public String[] detectPOSTags(String[] tokens) throws IOException {
        // Better to read file once at start of program & store model in instance
        // variable. but keeping here for simplicity in understanding.
        try (InputStream modelIn = new FileInputStream("en-pos-maxent.bin")) {

            // Initialize POS tagger tool
            POSTaggerME myCategorizer = new POSTaggerME(new POSModel(modelIn));

            // Tag sentence.
            String[] posTokens = myCategorizer.tag(tokens);
            System.out.println("POS Tags : " + Arrays.stream(posTokens).collect(Collectors.joining(" | ")));

            return posTokens;

        }
    }

    public String[] detectPOSTagsFr(String[] tokens) throws IOException {
        // Better to read file once at start of program & store model in instance
        // variable. but keeping here for simplicity in understanding.
        try (InputStream modelIn = new FileInputStream("fr-pos-ftb-morpho.bin")) {

            // Initialize POS tagger tool
            POSTaggerME myCategorizer = new POSTaggerME(new POSModel(modelIn));

            // Tag sentence.
            String[] posTokens = myCategorizer.tag(tokens);
            System.out.println("POS Tags : " + Arrays.stream(posTokens).collect(Collectors.joining(" | ")));

            return posTokens;

        }
    }
}


