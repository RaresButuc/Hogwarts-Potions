package com.codecool.hogwarts_potions.model;

import com.codecool.hogwarts_potions.service.RecipeService;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "potions")
public class Potion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @JsonIgnore
    private Long id;
    private String name;
    @ManyToOne(cascade = CascadeType.MERGE)
    private Student student;
    @ManyToMany(cascade = CascadeType.MERGE)
    private List<Ingredient> ingredients;
    @ManyToOne(cascade = CascadeType.MERGE)
    private Recipe recipe;
    private BrewingStatus brewingStatus;

    @Override
    public String toString() {
        return "Potion{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", student=" + student +
                ", ingredients=" + ingredients +
                ", recipe=" + recipe +
                ", brewingStatus=" + brewingStatus +
                '}';
    }
}
