package com.example.restaurantApp.controllers;

import com.example.restaurantApp.domain.Ingredient;
import com.example.restaurantApp.services.IngredientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ingredient")
public class IngredientController {
    @Autowired
    private IngredientService ingredientService;

    @GetMapping
    public List<Ingredient> getAllIngredients(){
        return ingredientService.getAllIngredient();
    }

    @PutMapping
    public int addIngredient(@RequestBody Ingredient ingredient){
        return ingredientService.addIngredient(ingredient);
    }
}
