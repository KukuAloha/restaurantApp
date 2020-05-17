package com.example.restaurantApp.domain;


import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;

import javax.persistence.*;
import java.util.Set;

@Data
@Entity
@Table(name="menu")
public class Menu {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name="description")
    private String description;

    @OneToMany(fetch = FetchType.EAGER,mappedBy = "menu")
    private Set<Dish> dishes;

    @Column(name = "url")
    private String url;

    @JsonBackReference
    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "restaurant_id")
    private Restaurant restaurant;
}
