package com.example.RestaurantChat.languageDetection;

import opennlp.tools.langdetect.Language;
import opennlp.tools.langdetect.LanguageDetectorME;
import opennlp.tools.langdetect.LanguageDetectorModel;

import java.io.File;
import java.io.IOException;

public class LanguageDetector {

    /*public static void main(String[] args) throws IOException*/
    public String detectLanguage( String language) throws IOException{

        LanguageMapper languageMapper = new LanguageMapper();

        // load the trained Language Detector Model file
        File modelFile = new File("langdetect-183.bin");

        LanguageDetectorModel trainedModel = new LanguageDetectorModel(modelFile);

        // load the model
        LanguageDetectorME languageDetector = new LanguageDetectorME(trainedModel);

        // use the model for predicting the language
        //Spanish
        Language[] languages = languageDetector.predictLanguages(language);

        // French
        //Language[] languages = ld.predictLanguages("Je peux vous donner quelques exemples de méthodes qui ont fonctionné pour moi.");

        // English
        //Language[] languages = ld.predictLanguages("I can give you some examples of methods that have worked for me.");

        System.out.println("Predicted language: "+ languageMapper.getLanguage(languages[0].getLang()));
        return languageMapper.getLanguage(languages[0].getLang());

        // uncomment to know confidence for rest of the languages
	       /* for(Language language:languages){
	            System.out.println(language.getLang()+"  confidence:"+language.getConfidence());
	        }*/



    }
}
