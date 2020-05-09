package com.example.restaurantApp.repository;

import com.example.restaurantApp.domain.Dish;
import com.example.restaurantApp.domain.Menu;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface DishRepository extends CrudRepository<Dish, Integer> {

    @Transactional
    List<Dish> findDishesByMenuId(int id);

    @Transactional
    Dish findDishById(int id);

    @Transactional
    @Modifying
    @Query("update Dish set url = :link where id = :dishId")
    void updateDishLinkById(@Param("dishId") int dishId,
                            @Param("link") String link);
}
