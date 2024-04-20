package com.codecool.hogwarts_potions.service;

import com.codecool.hogwarts_potions.interfaces.RecipesRepository;
import com.codecool.hogwarts_potions.model.Recipe;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RecipeService {
    private RecipesRepository recipesRepository;

    public RecipeService(RecipesRepository recipesRepository) {
        this.recipesRepository = recipesRepository;
    }

    public List<Recipe> getAllRecipes() {
        return recipesRepository.findAll();
    }

    public void postANewRecipe(Recipe recipe) {
        System.out.println(recipe);
        recipesRepository.save(recipe);
    }
}
