package com.example.RestaurantChat.tokenization;

import opennlp.tools.tokenize.TokenizerME;
import opennlp.tools.tokenize.TokenizerModel;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.stream.Collectors;

public class Tokenizing {

    public String[] tokenizeSentence(String sentence) throws FileNotFoundException, IOException {
        // Better to read file once at start of program & store model in instance
        // variable. but keeping here for simplicity in understanding.
        try (InputStream modelIn = new FileInputStream("en-token.bin")) {

            // Initialize tokenizer tool
            TokenizerME myCategorizer = new TokenizerME(new TokenizerModel(modelIn));

            // Tokenize sentence.
            String[] tokens = myCategorizer.tokenize(sentence);
            System.out.println("Tokenizer : " + Arrays.stream(tokens).collect(Collectors.joining(" | ")));

            return tokens;

        }
    }

    public String[] tokenizeSentenceFr(String sentence) throws FileNotFoundException, IOException {
        // Better to read file once at start of program & store model in instance
        // variable. but keeping here for simplicity in understanding.
        try (InputStream modelIn = new FileInputStream("opennlp-en-ud-ewt-tokens-1.0-1.9.3.bin")) {

            // Initialize tokenizer tool
            TokenizerME myCategorizer = new TokenizerME(new TokenizerModel(modelIn));

            // Tokenize sentence.
            String[] tokens = myCategorizer.tokenize(sentence);
            System.out.println("Tokenizer : " + Arrays.stream(tokens).collect(Collectors.joining(" | ")));

            return tokens;

        }
    }

}
