package com.example.restaurantApp.domain;


import javax.persistence.*;

@Entity
@Table(name="Ingredient")
public class Ingredient {
    @Id
    @Column(name="ingredientId")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name="ingredientName")
    private String name;

    @Column(name="weight")
    private double weight;




    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }
}
