package com.coderscampus.assignment9;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class RecipeFilteringApplication {

    public static void main(String[] args) {
        SpringApplication.run(RecipeFilteringApplication.class, args);
    }
}
/*
http://localhost:8080/api/recipes/all-recipes

http://localhost:8080/api/recipes/gluten-free

http://localhost:8080/api/recipes/vegan

http://localhost:8080/api/recipes/vegan-and-gluten-free

http://localhost:8080/api/recipes/vegetarian
*/



