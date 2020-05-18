package com.example.restaurantApp.repository;

import com.example.restaurantApp.domain.Dish;
import com.example.restaurantApp.domain.Ingredient;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.Collection;
import java.util.List;

@Repository
public interface IngredientRepository extends CrudRepository<Ingredient,Integer> {
    @Transactional
    @Modifying
    @Query("update Ingredient set url = :link where id = :ingredientId")
    void updateIngredientLinkById(@Param("ingredientId") int ingredientId,
                                  @Param("link") String link);

    @Transactional
    List<Ingredient> findIngredientsByDishes(Dish dish);
}
