package com.example.restaurantApp.controllers;

import com.example.restaurantApp.domain.CommentDish;
import com.example.restaurantApp.dto.CommentDishDto;
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
    public List<CommentDish> getAllCommentsByDishId(@RequestParam("id") int id){
        return commentDishService.getAllCommentByDishId(id);
    }

    @PostMapping("/addCommentDish")
    public void addCommentDish(@RequestBody CommentDishDto commentDish,
                               @RequestParam("idDish") int idDish,
                               @RequestParam("idUser") int idUser){
        commentDishService.addCommentDish(commentDish, idUser, idDish);
    }

    @DeleteMapping
    public void deleteCommentDish(@RequestParam int id){
        commentDishService.deleteCommentDish(id);
    }
}
