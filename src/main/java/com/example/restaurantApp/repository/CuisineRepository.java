package com.example.restaurantApp.repository;

import com.example.restaurantApp.domain.Cuisine;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CuisineRepository extends CrudRepository<Cuisine,Integer> {
}
