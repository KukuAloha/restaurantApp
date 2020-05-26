package com.example.restaurantApp.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;

import javax.persistence.*;
import java.util.Objects;
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

    @JsonBackReference
    @OneToMany(fetch = FetchType.LAZY,mappedBy = "dish")
    private Set<CommentDish> commentDishes;

    @JsonManagedReference
    @ManyToOne(fetch = FetchType.EAGER,cascade = CascadeType.ALL, optional = false)
    @JoinColumn(name = "menu_id")
    private Menu menu;

    @JsonBackReference
    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(name = "dish_ingredient",
                joinColumns = @JoinColumn(name = "dish_id"/*,referencedColumnName="id"*/),
                inverseJoinColumns = @JoinColumn(name = "ingredient_id"/*,referencedColumnName="id"*/))
    private Set<Ingredient> ingredients;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Dish that = (Dish) o;
        return id == that.id &&
                Objects.equals(name, that.name) &&
                Objects.equals(description,that.description) &&
                Objects.equals(url,that.url) &&
                Objects.equals(menu,that.menu);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, description, price, url, menu);
    }

}
