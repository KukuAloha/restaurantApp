package com.example.restaurantApp.services;

import com.example.restaurantApp.domain.Ingredient;

import java.util.List;

public interface IngredientService {
    List<Ingredient> getAllIngredient();
    int addIngredient(Ingredient ingredient);
    int deleteIngredient(int id);
}
