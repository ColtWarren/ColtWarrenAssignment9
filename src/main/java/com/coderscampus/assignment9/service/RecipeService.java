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

    public List<Recipe> getAllRecipes() {
        return repository.findAll();
    }

    public List<Recipe> getGlutenFreeRecipes() {
        return repository.findAll().stream()
                .filter(r -> Boolean.TRUE.equals(r.getGlutenFree()))
                .collect(Collectors.toList());
    }

    public List<Recipe> getVeganRecipes() {
        return repository.findAll().stream()
                .filter(r -> Boolean.TRUE.equals(r.getVegan()))
                .collect(Collectors.toList());
    }

    public List<Recipe> getVeganAndGlutenFreeRecipes() {
        return repository.findAll().stream()
                .filter(r -> Boolean.TRUE.equals(r.getVegan()) && Boolean.TRUE.equals(r.getGlutenFree()))
                .collect(Collectors.toList());
    }

    public List<Recipe> getVegetarianRecipes() {
        return repository.findAll().stream()
                .filter(r -> Boolean.TRUE.equals(r.getVegetarian()))
                .collect(Collectors.toList());
    }
}