package com.example.restaurantApp.domain;


import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name="commentDish")
public class CommentDish {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "commentDish")
    private String comment;

    //STARS



    @ManyToOne(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    @JoinColumn(name = "dish_id")
    private Dish dish;

    public Dish getDish() { return dish; }

    public void setDish(Dish dish) { this.dish = dish; }

    @ManyToOne(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id")
    private User user;

    public User getUser() { return user; }

    public void setUser(User user) { this.user = user; }




    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}
