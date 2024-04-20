package com.codecool.hogwarts_potions.interfaces;

import com.codecool.hogwarts_potions.model.Recipe;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RecipesRepository extends JpaRepository<Recipe, Long> {
}
