package com.example.restaurantApp.services;


import com.example.restaurantApp.domain.CommentDish;
import com.example.restaurantApp.dto.CommentDishDto;

import java.util.List;

public interface CommentDishService {

    List<CommentDish> getAllCommentDish();

    void addCommentDish(CommentDishDto commentDishDto, int idUser, int idDish);

    void deleteCommentDish(int id);

    List<CommentDish> getAllCommentByDishId(int id);
}
