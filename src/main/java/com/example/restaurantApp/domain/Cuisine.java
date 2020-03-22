package com.example.restaurantApp.domain;


import javax.persistence.*;
import java.util.Set;

@Entity
public class Cuisine {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "cuisineName")
    private String name;



    @ManyToMany(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    @JoinTable(name = "cuisine_restaurant",
                joinColumns = @JoinColumn(name = "cuisine_id"),
                inverseJoinColumns = @JoinColumn(name = "restaurant_id"))
    private Set<Restaurant> restaurants;

    public Set<Restaurant> getRestaurants() { return restaurants; }

    public void setRestaurants(Set<Restaurant> restaurants) { this.restaurants = restaurants; }





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

}
