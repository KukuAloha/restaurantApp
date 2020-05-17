package com.example.restaurantApp.controllers;

import com.example.restaurantApp.domain.CommentDish;
import com.example.restaurantApp.services.CommentDishService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/commentDish")
public class CommentDishController {

    @Autowired
    private CommentDishService commentDishService;

    @GetMapping
    public List<CommentDish> getAllCommentsDish(){
        return commentDishService.getAllCommentDish();
    }

    @PostMapping
    public void addCommentDish(@RequestBody CommentDish commentDish,
                               @RequestParam("idDish") int idDish,
                               @RequestParam("idUser") int idUser){
        commentDishService.addCommentDish(commentDish, idUser, idDish);
    }

    @DeleteMapping
    public void deleteCommentDish(@RequestParam int id){
        commentDishService.deleteCommentDish(id);
    }
}
