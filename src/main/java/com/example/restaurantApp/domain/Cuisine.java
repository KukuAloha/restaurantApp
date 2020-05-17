package com.example.restaurantApp.domain;


import lombok.Data;

import javax.persistence.*;
import java.util.Set;

@Data
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
}
