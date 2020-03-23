package com.example.restaurantApp.domain;


import javax.persistence.*;
import java.util.Set;

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



    @OneToMany(fetch = FetchType.EAGER,mappedBy = "restaurant")
    private Set<CommentRestaurant> commentRestaurants;

    public Set<CommentRestaurant> getCommentRestaurants() { return commentRestaurants; }

    public void setCommentRestaurants(Set<CommentRestaurant> commentRestaurants) { this.commentRestaurants = commentRestaurants; }

    @OneToOne(mappedBy = "restaurant")
    private Menu menu;

    public Menu getMenu() {
        return menu;
    }

    public void setMenu(Menu menu) {
        this.menu = menu;
    }

    @ManyToMany(fetch = FetchType.LAZY,cascade = CascadeType.ALL,mappedBy = "restaurants")
    private Set<Cuisine> cuisines;

    public Set<Cuisine> getCuisines() { return cuisines; }

    public void setCuisines(Set<Cuisine> cuisines) { this.cuisines = cuisines; }





    public int getId() { return id; }

    public void setId(int id) { this.id = id; }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

}
