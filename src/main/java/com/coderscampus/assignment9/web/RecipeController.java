package com.coderscampus.assignment9.web;

import com.coderscampus.assignment9.domain.Recipe;
import com.coderscampus.assignment9.service.RecipeService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/recipes")
public class RecipeController {

    private final RecipeService recipeService;

    public RecipeController(RecipeService recipeService) {
        this.recipeService = recipeService;
    }

    @GetMapping("/all-recipes")
    public List<Recipe> getAllRecipes() {
        return recipeService.getAll();
    }

    @GetMapping("/gluten-free")
    public List<Recipe> getGlutenFreeRecipes() {
        return recipeService.getGlutenFree();
    }

    @GetMapping("/vegan")
    public List<Recipe> getVeganRecipes() {
        return recipeService.getVegan();
    }

    @GetMapping("/vegan-and-gluten-free")
    public List<Recipe> getVeganAndGlutenFreeRecipes() {
        return recipeService.getVeganAndGlutenFree();
    }

    @GetMapping("/vegetarian")
    public List<Recipe> getVegetarianRecipes() {
        return recipeService.getVegetarian();
    }
}