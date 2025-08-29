package com.coderscampus.assignment9.repository;

import com.coderscampus.assignment9.domain.Recipe;
import com.coderscampus.assignment9.service.RecipeFileService;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class RecipeRepository {
    private final RecipeFileService recipeFileService;
    private List<Recipe> recipes = new ArrayList<>();

    public RecipeRepository(RecipeFileService recipeFileService) {
        this.recipeFileService = recipeFileService;
    }

    @PostConstruct
    private void init() {
        recipes = recipeFileService.loadRecipes("recipes.txt");
    }

    public List<Recipe> getAll() {
       return recipes;
    }
}