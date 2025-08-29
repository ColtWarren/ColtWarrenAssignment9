package com.coderscampus.assignment9.service;

import com.coderscampus.assignment9.domain.Recipe;
import com.coderscampus.assignment9.repository.RecipeRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class RecipeService {

    private final RecipeRepository repository;

    public RecipeService(RecipeRepository repository) {
        this.repository = repository;
    }

    public List<Recipe> getAll() {
        return repository.getAll();
    }

    public List<Recipe> getGlutenFree() {
        return getAll().stream()
                .filter(Recipe::getGlutenFree)
                .collect(Collectors.toList());
    }

    public List<Recipe> getVegan() {
        return getAll().stream()
                .filter(Recipe::getVegan)
                .collect(Collectors.toList());
    }

    public List<Recipe> getVeganAndGlutenFree() {
        return getAll().stream()
                .filter(recipe -> recipe.getVegan() && recipe.getGlutenFree())
                .collect(Collectors.toList());
    }

    public List<Recipe> getVegetarian() {
        return getAll().stream()
                .filter((Recipe::getVegetarian)                           )
                .collect(Collectors.toList());
    }
}