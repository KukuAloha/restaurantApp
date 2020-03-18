package com.example.restaurantApp.repository;

import com.example.restaurantApp.domain.Ingredient;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IngredientRepository extends CrudRepository<Ingredient,Integer> {
}
