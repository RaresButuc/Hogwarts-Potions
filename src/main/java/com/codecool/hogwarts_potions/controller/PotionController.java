package com.codecool.hogwarts_potions.controller;

import com.codecool.hogwarts_potions.model.Potion;
import com.codecool.hogwarts_potions.service.PotionService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/potions")
public class PotionController {
    private PotionService potionService;

    public PotionController(PotionService potionService) {
        this.potionService = potionService;
    }

    @GetMapping
    public List<Potion> returnAllPotions() {
        return potionService.getAllPotions();
    }

    @PostMapping
    public void postAPotion(@RequestBody Potion newPotion) {
        potionService.postANewPotion(newPotion);
    }
}
