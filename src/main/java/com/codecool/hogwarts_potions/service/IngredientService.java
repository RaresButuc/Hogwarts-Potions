package com.codecool.hogwarts_potions.service;

import com.codecool.hogwarts_potions.interfaces.IngredientsRepository;
import com.codecool.hogwarts_potions.model.Ingredient;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IngredientService {
    private IngredientsRepository ingredientsRepository;

    public IngredientService(IngredientsRepository ingredientsRepository) {
        this.ingredientsRepository = ingredientsRepository;
    }

    public List<Ingredient> getAllIngredients() {
        return ingredientsRepository.findAll();
    }

    public void postANewIngredient(Ingredient ingredient) {
        ingredientsRepository.save(ingredient);
    }
}
