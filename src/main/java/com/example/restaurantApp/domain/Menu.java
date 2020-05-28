package com.example.restaurantApp.domain;


import com.fasterxml.jackson.annotation.*;
import lombok.*;

import javax.persistence.*;
import java.util.Objects;
import java.util.Set;


@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name="menu")
public class Menu {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name="description")
    private String description;

    @Column(name = "url")
    private String url;

    @JsonBackReference
    @OneToMany(fetch = FetchType.EAGER,mappedBy = "menu")
    private Set<Dish> dishes;


    //@JsonIdentityInfo(
    //  generator = ObjectIdGenerators.PropertyGenerator.class,
    //  property = "id") 2 вариант вывода данных
    @JsonManagedReference
    @ManyToOne(fetch = FetchType.EAGER, optional = false, cascade = CascadeType.ALL)
    @JoinColumn(name = "restaurant_id")
    private Restaurant restaurant;

   /* @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Menu that = (Menu) o;
        return id == that.id &&
                Objects.equals(description, that.description) &&
                Objects.equals(dishes, that.dishes) &&
                Objects.equals(url, that.url) &&
                Objects.equals(restaurant, that.restaurant);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, description, dishes, url, restaurant);
    }*/
}
