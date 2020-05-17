package com.example.restaurantApp.controllers;


import com.example.restaurantApp.domain.Cuisine;
import com.example.restaurantApp.services.CuisineService;
import org.springframework.beans.factory.annotation.Autowired;
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
    public int addCuisine(@RequestBody Cuisine cuisine){
        return cuisineService.addCuisine(cuisine);
    }

    @DeleteMapping
    public int deleteCuisine(@RequestParam int id){ return cuisineService.deleteCuisine(id); }
}
