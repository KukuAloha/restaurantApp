package com.example.restaurantApp.domain;


import com.fasterxml.jackson.annotation.*;
import lombok.*;

import javax.persistence.*;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name="restaurant")
public class Restaurant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name= "restaurantName" )
    private String name;

    @Column(name="address")
    private String address;

    @Column(name = "description")
    private String description;

    @Column(name = "url")
    private String url;

    @Column(name = "stars")
    private int stars;

    @Column(name = "avgCheck")
    private int avgCheck;

    @JsonBackReference
    @OneToMany(fetch = FetchType.LAZY,mappedBy = "restaurant")
    private Set<CommentRestaurant> commentRestaurants;

    @JsonBackReference
    //@JsonIdentityInfo(
    //  generator = ObjectIdGenerators.PropertyGenerator.class,
    //  property = "id") 2 вариант вывода данных
    @OneToMany(mappedBy = "restaurant", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Set<Menu> menu;

    @JsonBackReference
    @ManyToMany(fetch = FetchType.LAZY,cascade = CascadeType.ALL,mappedBy = "restaurants")
    private Set<Cuisine> cuisines;

    /*@Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Restaurant that = (Restaurant) o;
        return id == that.id &&
                Objects.equals(name,that.name) &&
                Objects.equals(address, that.address) &&
                Objects.equals(description,that.description) &&
                Objects.equals(url, that.url) &&
                Objects.equals(menu, that.menu);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, address, description, url, menu);*/
    //}

}
