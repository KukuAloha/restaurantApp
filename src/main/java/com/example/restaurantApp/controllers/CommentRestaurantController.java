package com.example.restaurantApp.controllers;

import com.example.restaurantApp.domain.CommentRestaurant;
import com.example.restaurantApp.dto.CommentRestaurantDto;
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
    public List<CommentRestaurant> getAllCommentsRestaurantByRestaurantId(@RequestParam("id") int id){
        return  commentRestaurantService.getAllCommentByRestaurantId(id);
    }

    @PostMapping("/addCommentRestaurant")
    public void addCommentRestaurant(@RequestBody CommentRestaurantDto commentRestaurant,
                                     @RequestParam("idRestaurant") int idRestaurant,
                                     @RequestParam("idUser") int idUser){
        commentRestaurantService.addCommentRestaurant(commentRestaurant, idUser, idRestaurant);
    }

    @DeleteMapping
    public void deleteCommentRestaurant(@RequestParam int id){
        commentRestaurantService.deleteCommentRestaurant(id);
    }
}
