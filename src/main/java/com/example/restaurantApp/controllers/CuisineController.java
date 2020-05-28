package com.example.restaurantApp.controllers;


import com.example.restaurantApp.domain.Cuisine;
import com.example.restaurantApp.domain.Restaurant;
import com.example.restaurantApp.dto.CuisineDto;
import com.example.restaurantApp.services.CuisineService;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cuisine")
public class CuisineController {

    @Autowired
    private CuisineService cuisineService;

    @GetMapping
    public List<Cuisine> getAllCuisines(){
        return cuisineService.getAllCuisines();
    }

    @PostMapping
    public int addCuisine(@RequestBody CuisineDto cuisine){
        return cuisineService.addCuisine(cuisine);
    }

    @PostMapping("/addCuisineToRestaurant")
    public void addCuisineToRestaurant(@RequestParam("idOfRestaurant") int idOfRestaurant,
                                       @RequestParam("idOfCuisine") int idCuisine) {
        cuisineService.addCuisineToRestaurant(idOfRestaurant, idCuisine);
    }

    @DeleteMapping
    public int deleteCuisine(@RequestParam int id){ return cuisineService.deleteCuisine(id); }

    @GetMapping("/getCuisinesByRestaurant")
    public List<Cuisine> getCuisinesByRestaurantId(@RequestParam("id") int id) {
        return cuisineService.getCuisinesForRestaurant(id);
    }

    @GetMapping("/getRestaurantsByCuisine")
    public List<Restaurant> getRestaurantsByCuisine(@RequestParam("id") int id) {
        return cuisineService.getRestaurantsByCuisine(id);
    }
}
