package com.example.RestaurantChat.languageDetection;

import opennlp.tools.langdetect.Language;
import opennlp.tools.langdetect.LanguageDetectorME;
import opennlp.tools.langdetect.LanguageDetectorModel;

import java.io.File;
import java.io.IOException;

public class LanguageDetector {

    public String detectLanguage( String language) throws IOException{

        LanguageMapper languageMapper = new LanguageMapper();

        // load the trained Language Detector Model file
        File modelFile = new File("langdetect-183.bin");

        LanguageDetectorModel trainedModel = new LanguageDetectorModel(modelFile);

        // load the model
        LanguageDetectorME languageDetector = new LanguageDetectorME(trainedModel);

        // use the model for predicting the language
        Language[] languages = languageDetector.predictLanguages(language);

        System.out.println("Predicted language: "+ languageMapper.getLanguage(languages[0].getLang()));
        return languageMapper.getLanguage(languages[0].getLang());

    }
}
