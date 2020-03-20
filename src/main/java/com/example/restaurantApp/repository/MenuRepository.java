package com.example.restaurantApp.repository;

import com.example.restaurantApp.domain.Menu;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestBody;

@Repository
public interface MenuRepository extends CrudRepository<Menu,Integer> {
}