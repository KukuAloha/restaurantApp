package com.example.restaurantApp.controllers;

import com.example.restaurantApp.domain.Dish;
import com.example.restaurantApp.services.DishService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/dish")
public class DishController {
    @Autowired
    private DishService dishService;

    @GetMapping
    public List<Dish> getAllDishes(){
        return dishService.getAllDishes();
    }

    @PutMapping
    public int addDish(@RequestBody Dish dish){
        return dishService.addDish(dish);
    }

    @DeleteMapping
    public int deleteDish(@RequestParam int id){
        return dishService.deleteDish(id);
    }
}
