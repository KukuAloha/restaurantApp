package com.example.restaurantApp.services;

import com.example.restaurantApp.domain.Ingredient;
import org.springframework.web.multipart.MultipartFile;

import java.util.Collection;
import java.util.List;

public interface IngredientService {
    List<Ingredient> getAllIngredient();

    List<Ingredient> getIngredientsByDishId(int id);

    void addIngredient(Ingredient ingredient);

    int deleteIngredient(int id);

    void addIngredientToDish(int idOfIngredient, int idOfDish);

    void uploadIngredientImage(int ingredientId, MultipartFile file);
}
