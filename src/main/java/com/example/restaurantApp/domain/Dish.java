package com.example.restaurantApp.domain;

import javax.persistence.*;
import java.util.Set;

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




    @OneToMany(fetch = FetchType.EAGER,mappedBy = "dish")
    private Set<CommentDish> commentDishes;

    public Set<CommentDish> getCommentDishes() { return commentDishes; }

    public void setCommentDishes(Set<CommentDish> commentDishes) { this.commentDishes = commentDishes; }

    @ManyToOne(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    @JoinColumn(name = "menu_id")
    private Menu menu;

    public Menu getMenu() { return menu; }

    public void setMenu(Menu menu) { this.menu = menu; }

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(name = "dish_ingredient",
                joinColumns = @JoinColumn(name = "dish_id"/*,referencedColumnName="id"*/),
                inverseJoinColumns = @JoinColumn(name = "ingredient_id"/*,referencedColumnName="id"*/))
    private Set<Ingredient> ingredients;

    public Set<Ingredient> getIngredients() { return ingredients; }

    public void setIngredients(Set<Ingredient> ingredients) { this.ingredients = ingredients; }




    public int getId() { return id; }

    public void setId(int id) { this.id = id; }

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
