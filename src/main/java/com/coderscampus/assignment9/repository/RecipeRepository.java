package com.coderscampus.assignment9.repository;

import com.coderscampus.assignment9.domain.Recipe;
import com.coderscampus.assignment9.service.RecipeFileService;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class RecipeRepository {
    private final RecipeFileService fileService;
    private List<Recipe> recipes = new ArrayList<>();

    public RecipeRepository(RecipeFileService fileService) {
        this.fileService = fileService;
    }

    @PostConstruct
    private void init() {
        this.recipes = fileService.loadRecipes("recipes.txt");
    }

    public List<Recipe> findAll() {
        return List.copyOf(recipes);
    }
}