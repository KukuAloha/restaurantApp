package com.example.restaurantApp.services.impl;

import com.example.restaurantApp.domain.CommentDish;
import com.example.restaurantApp.dto.CommentDishDto;
import com.example.restaurantApp.repository.CommentDishRepository;
import com.example.restaurantApp.repository.DishRepository;
import com.example.restaurantApp.repository.UserRepository;
import com.example.restaurantApp.services.CommentDishService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentDishServiceImpl implements CommentDishService {

    @Autowired
    private CommentDishRepository commentDishRepository;
    @Autowired
    private DishRepository dishRepository;
    @Autowired
    private UserRepository userRepository;

    @Override
    public List<CommentDish> getAllCommentDish() {
        return (List<CommentDish>) commentDishRepository.findAll();
    }

    @Override
    public void addCommentDish(CommentDishDto commentDishDto, int idUser, int idDish) {
        CommentDish commentDish = new CommentDish();

        commentDish.setComment(commentDishDto.getComment());

        commentDish.setUser(userRepository.findById(idUser).get());
        commentDish.setDish(dishRepository.findById(idDish).get());
        commentDishRepository.save(commentDish);
    }

    @Override
    public void deleteCommentDish(int id) {
        commentDishRepository.deleteById(id);
    }
}
