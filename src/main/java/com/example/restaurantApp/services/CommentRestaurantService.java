package com.example.restaurantApp.services;

import com.example.restaurantApp.domain.CommentRestaurant;
import com.example.restaurantApp.dto.CommentRestaurantDto;

import java.util.List;

public interface CommentRestaurantService {

    List<CommentRestaurant> getAllCommentRestaurant();

    void addCommentRestaurant(CommentRestaurantDto commentRestaurantDto, int idUser, int idRestaurant);
    void deleteCommentRestaurant(int id);


    List<CommentRestaurant> getAllCommentByRestaurantId(int id);
}
