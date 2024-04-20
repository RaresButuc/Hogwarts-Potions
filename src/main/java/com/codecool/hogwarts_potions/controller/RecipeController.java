package com.codecool.hogwarts_potions.controller;

import com.codecool.hogwarts_potions.model.Recipe;
import com.codecool.hogwarts_potions.service.RecipeService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/recipes")
public class RecipeController {
    private RecipeService recipeService;

    public RecipeController(RecipeService recipeService) {
        this.recipeService = recipeService;
    }

    @GetMapping
    public List<Recipe> returnAllRecipes() {
        return recipeService.getAllRecipes();
    }

    @PostMapping
    public void postARecipe(@RequestBody Recipe recipe) {
        recipeService.postANewRecipe(recipe);
    }
}
