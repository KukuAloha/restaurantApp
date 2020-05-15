package com.example.restaurantApp.services;

import com.example.restaurantApp.domain.CommentRestaurant;

import java.util.List;

public interface CommentRestaurantService {
    List<CommentRestaurant> getAllCommentRestaurant();
    void addCommentRestaurant(CommentRestaurant commentRestaurant);
    void deleteCommentRestaurant(int id);

}
