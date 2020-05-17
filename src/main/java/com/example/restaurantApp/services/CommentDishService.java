package com.example.restaurantApp.services;


import com.example.restaurantApp.domain.CommentDish;

import java.util.List;

public interface CommentDishService {
    List<CommentDish> getAllCommentDish();
    void addCommentDish(CommentDish commentDish, int idUser, int idDish);
    void deleteCommentDish(int id);


}
