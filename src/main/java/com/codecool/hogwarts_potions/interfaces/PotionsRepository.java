package com.codecool.hogwarts_potions.interfaces;

import com.codecool.hogwarts_potions.model.Potion;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PotionsRepository extends JpaRepository<Potion, Long> {
}
