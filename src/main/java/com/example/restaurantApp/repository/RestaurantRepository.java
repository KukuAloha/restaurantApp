package com.example.restaurantApp.repository;

import com.example.restaurantApp.domain.Restaurant;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;


@Repository
public interface RestaurantRepository extends CrudRepository<Restaurant,Integer> {
    @Transactional
    @Modifying
    @Query("update Restaurant set url = :link where id = :restaurantId")
    void updateRestaurantLinkById(@Param("restaurantId") int restaurantId,
                                  @Param("link") String link);

}
