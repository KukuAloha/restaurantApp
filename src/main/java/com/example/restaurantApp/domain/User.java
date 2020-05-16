package com.example.restaurantApp.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
@Table(name="user")
@Data
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "firstName")
    private String firstName;

    @Column(name = "lastName")
    private String lastName;

    @Column(name = "login")
    private String login;

    @Column(name = "email")
    private String email;

    @Column(name = "password")
    private String password;

    @JsonBackReference
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "user_roles",
            joinColumns = {@JoinColumn(name = "user_id", referencedColumnName = "id") },
            inverseJoinColumns = {@JoinColumn(name = "role_id", referencedColumnName = "id")})
    private List<Role> roles;

    @OneToMany(fetch = FetchType.EAGER,mappedBy = "user")
    private Set<CommentDish> commentDishes;

    public Set<CommentDish> getCommentDishes() { return commentDishes; }

    public void setCommentDishes(Set<CommentDish> commentDishes) { this.commentDishes = commentDishes; }

    @OneToMany(fetch = FetchType.EAGER,mappedBy = "user")
    private Set<CommentRestaurant> commentRestaurants;

    public Set<CommentRestaurant> getCommentRestaurants() { return commentRestaurants; }

    public void setCommentRestaurants(Set<CommentRestaurant> commentRestaurants) { this.commentRestaurants = commentRestaurants; }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
