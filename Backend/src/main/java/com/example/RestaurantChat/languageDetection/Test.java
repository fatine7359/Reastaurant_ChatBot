package com.example.RestaurantChat.languageDetection;

import opennlp.tools.langdetect.*;
import opennlp.tools.util.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Arrays;

public class Test {



    public static void main(String[] args) throws FileNotFoundException, IOException{

            InputStreamFactory dataIn
                    = new MarkableFileInputStreamFactory(
                    new File("DoccatSample.txt"));
            ObjectStream lineStream = new PlainTextByLineStream(dataIn, "UTF-8");
            LanguageDetectorSampleStream sampleStream
                    = new LanguageDetectorSampleStream(lineStream);
            TrainingParameters params = new TrainingParameters();
            params.put(TrainingParameters.ITERATIONS_PARAM, 100);
            params.put(TrainingParameters.CUTOFF_PARAM, 5);
            params.put("DataIndexer", "TwoPass");
            params.put(TrainingParameters.ALGORITHM_PARAM, "NAIVEBAYES");

            LanguageDetectorModel model = LanguageDetectorME
                    .train(sampleStream, params, new LanguageDetectorFactory());

            LanguageDetectorME ld = new LanguageDetectorME(model);
            Language[] languages = ld
                    .predictLanguages("Hello guys");

            System.out.printf(languages[0].toString() + languages[1].toString() + languages[2].toString() + languages[3].toString());
        /*assertThat(Arrays.asList(languages))
                .extracting("lang", "confidence")
                .contains(
                        tuple("pob", 0.9999999950605625),
                        tuple("ita", 4.939427661577956E-9),
                        tuple("spa", 9.665954064665144E-15),
                        tuple("fra", 8.250349924885834E-25)));*/
        }

}
