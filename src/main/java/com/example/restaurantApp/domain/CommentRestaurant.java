package com.example.restaurantApp.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;

import javax.persistence.*;
import java.util.Objects;
import java.util.Set;

@Data
@Entity
@Table(name = "commentRestaurant")
public class CommentRestaurant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "commentRest")
    private String comment;

    @Column(name = "stars")
    private int stars;

    @JsonBackReference
    @ManyToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL, optional = false)
    @JoinColumn(name = "restaurant_id")
    private Restaurant restaurant;

    @JsonBackReference
    @ManyToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL, optional = false)
    @JoinColumn(name = "user_id")
    private User user;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CommentRestaurant that = (CommentRestaurant) o;
        return id == that.id &&
                Objects.equals(stars, that.stars) &&
                Objects.equals(comment, that.comment) &&
                Objects.equals(restaurant, that.restaurant) &&
                Objects.equals(user, that.user);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, comment, stars, restaurant, user);
    }
}
