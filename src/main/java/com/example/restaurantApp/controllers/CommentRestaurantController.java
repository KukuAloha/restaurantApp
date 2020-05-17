package com.example.restaurantApp.controllers;

import com.example.restaurantApp.domain.CommentRestaurant;
import com.example.restaurantApp.services.CommentRestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/commentRestaurant")
public class CommentRestaurantController {

    @Autowired
    private CommentRestaurantService commentRestaurantService;

    @GetMapping
    public List<CommentRestaurant> getAllCommentsRestaurant(){
        return  commentRestaurantService.getAllCommentRestaurant();
    }

    @PostMapping
    public void addCommentRestaurant(@RequestBody CommentRestaurant commentRestaurant,
                                     @Param("idRestaurant") int idRestaurant,
                                     @Param("idUser") int idUser){
        commentRestaurantService.addCommentRestaurant(commentRestaurant, idUser, idRestaurant);
    }

    @DeleteMapping
    public void deleteCommentRestaurant(@RequestParam int id){
        commentRestaurantService.deleteCommentRestaurant(id);
    }
}
