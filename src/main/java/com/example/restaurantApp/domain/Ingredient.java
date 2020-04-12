package com.example.restaurantApp.domain;


import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name="ingredient")
public class Ingredient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name="ingredientName")
    private String name;

    @Column(name="weight")
    private double weight;





    @ManyToMany(fetch = FetchType.LAZY,cascade = CascadeType.ALL,mappedBy = "ingredients")
    private Set<Dish> dishes;

    public Set<Dish> getDishes() { return dishes; }

    public void setDishes(Set<Dish> dishes) { this.dishes = dishes; }





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
