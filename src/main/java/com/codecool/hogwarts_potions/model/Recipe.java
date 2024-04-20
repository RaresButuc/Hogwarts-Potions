package com.codecool.hogwarts_potions.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "recipes")
public class Recipe {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @JsonIgnore
    private Long id;
    private String name;

    @ManyToOne(cascade = CascadeType.MERGE)
    private Student student;

    @ManyToMany(cascade = CascadeType.MERGE)
    private List<Ingredient> ingredients;


    @Override
    public String toString() {
        return "Recipe{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", studentThatBrewIt=" + student +
                ", ingredients=" + ingredients +
                '}';
    }
}
