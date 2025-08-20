package com.coderscampus.assignment9.service;

import com.coderscampus.assignment9.domain.Recipe;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileReader;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;

@Service
public class RecipeFileService {

    public List<Recipe> loadRecipes(String filename) {
        List<Recipe> recipes = new ArrayList<>();
        String projectRoot = System.getProperty("user.dir");
        File file = new File(projectRoot + File.separator + filename);

        try (Reader reader = new FileReader(file);
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
                        parseBool(record.get("Dairy Free")),
                        parseBool(record.get("Gluten Free")),
                        record.get("Instructions"),
                        parseDouble(record.get("Preparation Minutes")),
                        parseDouble(record.get("Price Per Serving")),
                        parseInt(record.get("Ready In Minutes")),
                        parseInt(record.get("Servings")),
                        parseDouble(record.get("Spoonacular Score")),
                        record.get("Title"),
                        parseBool(record.get("Vegan")),
                        parseBool(record.get("Vegetarian"))
                );
                recipes.add(recipe);
            }
        } catch (Exception e) {
            throw new RuntimeException("Failed to load recipes", e);
        }
        return recipes;
    }

    private Integer parseInt(String value) {
        if (value == null || value.isBlank()) return null;
        try {
            return Integer.parseInt(value.trim());
        } catch (NumberFormatException e) {
            return null;
        }
    }

    private Double parseDouble(String value) {
        if (value == null || value.isBlank()) return null;
        try {
            return Double.parseDouble(value.trim());
        } catch (NumberFormatException e) {
            return null;
        }
    }

    private Boolean parseBool(String value) {
        if (value == null || value.isBlank()) return null;
        String normalized = value.trim().toLowerCase();
        return normalized.equals("true") || normalized.equals("1");
    }

    public List<Recipe> readRecipeFile() {
        return List.of();
    }
}