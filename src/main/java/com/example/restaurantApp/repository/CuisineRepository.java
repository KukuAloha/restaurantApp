package com.example.restaurantApp.repository;

import com.example.restaurantApp.domain.Cuisine;
import com.example.restaurantApp.domain.Restaurant;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface CuisineRepository extends CrudRepository<Cuisine,Integer> {

    @Transactional
    List<Cuisine> findCuisinesByRestaurants(Restaurant restaurant);
}
