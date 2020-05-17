package com.example.restaurantApp.domain;


import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;

import javax.persistence.*;
import java.util.Set;

@Data
@Entity
@Table(name="ingredient")
public class Ingredient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name="ingredientName")
    private String name;

    @Column(name = "url")
    private String url;

    @Column(name="weight")
    private double weight;

    @JsonBackReference
    @ManyToMany(fetch = FetchType.LAZY,cascade = CascadeType.ALL,mappedBy = "ingredients")
    private Set<Dish> dishes;

}
