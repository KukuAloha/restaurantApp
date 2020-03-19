package com.example.restaurantApp.domain;

import javax.persistence.*;

@Entity
@Table(name="Dish")
public class Dish {

    @Id
    @Column(name="dishId")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "dishName")
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name="price")
    private double price;




    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
