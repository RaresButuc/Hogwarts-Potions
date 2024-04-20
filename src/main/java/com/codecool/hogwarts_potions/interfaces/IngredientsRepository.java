package com.codecool.hogwarts_potions.interfaces;

import com.codecool.hogwarts_potions.model.Ingredient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IngredientsRepository extends JpaRepository<Ingredient, Long> {
}
