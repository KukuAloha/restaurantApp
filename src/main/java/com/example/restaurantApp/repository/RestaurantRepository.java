package com.example.restaurantApp.repository;

import com.example.restaurantApp.domain.Restaurant;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface RestaurantRepository extends CrudRepository<Restaurant,Integer> {
}
