package com.coderscampus.assignment9.service;

import com.coderscampus.assignment9.domain.Recipe;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.springframework.stereotype.Service;

import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

import static java.lang.Integer.parseInt;

@Service
public class RecipeFileService {

    public List<Recipe> loadRecipes(String filename) {
        List<Recipe> recipes = new ArrayList<>();
        try (FileReader reader = new FileReader(filename);
             CSVParser csvParser = CSVFormat.DEFAULT.builder()
                     .setHeader()
                     .setSkipHeaderRecord(true)
                     .setIgnoreHeaderCase(true)
                     .setTrim(true)
                     .setIgnoreSurroundingSpaces(true)
                     .setQuote('"')
                     .setEscape('\\')
                     .setIgnoreEmptyLines(true)
                     .build()
                     .parse(reader)) {

            for (CSVRecord record : csvParser) {
                Recipe recipe = new Recipe(
                        parseInt(record.get("Cooking Minutes")),
                        Boolean.parseBoolean(record.get("Dairy Free")),
                        Boolean.parseBoolean(record.get("Gluten Free")),
                        record.get("Instructions"),
                        Double.parseDouble(record.get("Preparation Minutes")),
                        Double.parseDouble(record.get("Price Per Serving")),
                        Integer.parseInt(record.get("Ready In Minutes")),
                        Integer.parseInt(record.get("Servings")),
                        Double.parseDouble(record.get("Spoonacular Score")),
                        record.get("Title"),
                        Boolean.parseBoolean(record.get("Vegan")),
                        Boolean.parseBoolean(record.get("Vegetarian"))
                );
                recipes.add(recipe);
            }
        } catch (Exception e) {
            throw new RuntimeException("Failed to load recipes", e);
        }
        return recipes;
    }
}
