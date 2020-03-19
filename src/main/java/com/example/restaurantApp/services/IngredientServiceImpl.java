package com.example.restaurantApp.services;

import com.example.restaurantApp.domain.Ingredient;
import com.example.restaurantApp.repository.IngredientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IngredientServiceImpl implements IngredientService {
    @Autowired
    private IngredientRepository ingredientRepository;

    @Override
    public List<Ingredient> getAllIngredient() {
        return (List<Ingredient>) ingredientRepository.findAll();
    }

    @Override
    public int addIngredient(Ingredient ingredient) {
        return ingredientRepository.save(ingredient).getId();
    }
}
