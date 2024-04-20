package com.codecool.hogwarts_potions.service;

import com.codecool.hogwarts_potions.interfaces.PotionsRepository;
import com.codecool.hogwarts_potions.model.BrewingStatus;
import com.codecool.hogwarts_potions.model.Ingredient;
import com.codecool.hogwarts_potions.model.Potion;
import com.codecool.hogwarts_potions.model.Recipe;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PotionService {
    private final PotionsRepository potionsRepository;

    //Search if there is any existing Recipe
    private RecipeService recipeService;

    public PotionService(PotionsRepository potionsRepository, RecipeService recipeService) {
        this.potionsRepository = potionsRepository;
        this.recipeService = recipeService;
    }

    public List<Potion> getAllPotions() {
        return potionsRepository.findAll();
    }

    public void postANewPotion(Potion potion) {
        potion.setRecipe(isThereAnyExistingRecipe(potion));

        potion.setBrewingStatus(thisPotionBrewingStatus(potion));

        if (potion.getBrewingStatus() == BrewingStatus.DISCOVERY) {
            List<Potion> allPotionsDiscoveredByStudent = getAllPotions().stream().filter(e -> e.getName().contains(e.getStudent().getName())).collect(Collectors.toList());
            potion.setName(potion.getStudent().getName() + "'s discovery #" + (allPotionsDiscoveredByStudent.size() + 1));
        }
        potionsRepository.save(potion);
    }

    private Recipe isThereAnyExistingRecipe(Potion potion) {
        List<Recipe> allRecipes = recipeService.getAllRecipes();

        for (Recipe recipe :
                allRecipes) {
            System.out.println(recipe);
            if (potion.getIngredients().stream()
                    .sorted(Comparator.comparing(Ingredient::getId)).collect(Collectors.toList())
                    == recipe.getIngredients().stream().sorted(Comparator.comparing(Ingredient::getId)).collect(Collectors.toList())) {
                return recipe;
            }
        }
        return null;
    }

    //Setting the Brewing Status which was not supposed to be inside Obj class
    private BrewingStatus thisPotionBrewingStatus(Potion potion) {
        if (potion.getIngredients().size() < 5) {
            return BrewingStatus.BREW;
        } else if (isThereAnyExistingRecipe(potion) != null) {
            return BrewingStatus.REPLICA;
        }
        return BrewingStatus.DISCOVERY;
    }

}
