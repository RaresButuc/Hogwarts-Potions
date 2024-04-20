package com.codecool.hogwarts_potions.controller;

import com.codecool.hogwarts_potions.model.Ingredient;
import com.codecool.hogwarts_potions.model.Student;
import com.codecool.hogwarts_potions.service.IngredientService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/ingredients")
public class IngredientsController {
    private IngredientService ingredientService;

    public IngredientsController(IngredientService ingredientService) {
        this.ingredientService = ingredientService;
    }

    @GetMapping
    public List<Ingredient> returnAllIngredients() {
        return ingredientService.getAllIngredients();
    }

    @PostMapping
    public void postAnIngredient(@RequestBody Ingredient ingredient) {
        ingredientService.postANewIngredient(ingredient);
    }
}
