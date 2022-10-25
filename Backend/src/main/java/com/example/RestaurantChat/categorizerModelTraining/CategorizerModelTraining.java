package com.example.RestaurantChat.categorizerModelTraining;

import opennlp.tools.doccat.*;
import opennlp.tools.util.*;
import opennlp.tools.util.model.ModelUtil;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

public class CategorizerModelTraining {

    public DoccatModel trainCategorizerModel() throws FileNotFoundException, IOException {
        // faq-categorizer.txt is a custom training data with categories as per our chat
        // requirements.

        InputStreamFactory inputStreamFactory = new MarkableFileInputStreamFactory(new File("faq-categorizer.txt"));
        ObjectStream<String> lineStream = new PlainTextByLineStream(inputStreamFactory, StandardCharsets.UTF_8);
        ObjectStream<DocumentSample> sampleStream = new DocumentSampleStream(lineStream);

        DoccatFactory factory = new DoccatFactory(new FeatureGenerator[] { new BagOfWordsFeatureGenerator() });

        TrainingParameters params = ModelUtil.createDefaultTrainingParameters();
        params.put(TrainingParameters.CUTOFF_PARAM, 0);

        // Train a model with classifications from above file.
        DoccatModel model = DocumentCategorizerME.train("en", sampleStream, params, factory);
        return model;
    }

    public DoccatModel trainCategorizerModelFr() throws FileNotFoundException, IOException {
        // faq-categorizer.txt is a custom training data with categories as per our chat
        // requirements.

        InputStreamFactory inputStreamFactory = new MarkableFileInputStreamFactory(new File("faq-categorizer-frensh.txt"));
        ObjectStream<String> lineStream = new PlainTextByLineStream(inputStreamFactory, StandardCharsets.UTF_8);
        ObjectStream<DocumentSample> sampleStream = new DocumentSampleStream(lineStream);

        DoccatFactory factory = new DoccatFactory(new FeatureGenerator[] { new BagOfWordsFeatureGenerator() });

        TrainingParameters params = ModelUtil.createDefaultTrainingParameters();
        params.put(TrainingParameters.CUTOFF_PARAM, 0);

        // Train a model with classifications from above file.
        DoccatModel model = DocumentCategorizerME.train("fr", sampleStream, params, factory);
        return model;
    }
}
