package com.example.restaurantApp.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;

import javax.persistence.*;
import java.util.Set;

@Data
@Entity
@Table(name="dish")
public class Dish {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "dishName")
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name="price")
    private double price;

    @Column(name = "url")
    private String url;


    @OneToMany(fetch = FetchType.EAGER,mappedBy = "dish")
    private Set<CommentDish> commentDishes;

    @JsonBackReference
    @ManyToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL, optional = false)
    @JoinColumn(name = "menu_id")
    private Menu menu;

    public Menu getMenu() { return menu; }

    public void setMenu(Menu menu) { this.menu = menu; }

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(name = "dish_ingredient",
                joinColumns = @JoinColumn(name = "dish_id"/*,referencedColumnName="id"*/),
                inverseJoinColumns = @JoinColumn(name = "ingredient_id"/*,referencedColumnName="id"*/))
    private Set<Ingredient> ingredients;

}
