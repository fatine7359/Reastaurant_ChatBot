package com.example.RestaurantChat.categoryDetection;

import opennlp.tools.doccat.DoccatModel;
import opennlp.tools.doccat.DocumentCategorizerME;

import java.io.IOException;

public class CategoryDetection {

    public String detectCategory(DoccatModel model, String[] finalTokens) throws IOException {

        // Initialize document categorizer tool
        DocumentCategorizerME myCategorizer = new DocumentCategorizerME(model);

        // Get best possible category.
        double[] probabilitiesOfOutcomes = myCategorizer.categorize(finalTokens);
        String category = myCategorizer.getBestCategory(probabilitiesOfOutcomes);
        System.out.println("Category: " + category);

        return category;

    }
}
