package com.example.restaurantApp.controllers;

import com.example.restaurantApp.domain.Restaurant;
import com.example.restaurantApp.services.RestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/restaurant")
public class RestaurantController {

    @Autowired
    private RestaurantService restaurantService;

    @GetMapping
    public List<Restaurant> getAllRestaurants(){
        return restaurantService.getAllRestaurants();
    }

    @PutMapping
    public int addRestaurant(@RequestBody Restaurant restaurant){
        return  restaurantService.addRestaurant(restaurant);
    }

    @DeleteMapping
    public int deleteRestaurant(@RequestParam int id){
        return restaurantService.deleteRestaurant(id);
    }
}
