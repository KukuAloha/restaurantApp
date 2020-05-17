package com.example.restaurantApp.repository;

import com.example.restaurantApp.domain.CommentRestaurant;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface CommentRestaurantRepository extends CrudRepository<CommentRestaurant,Integer> {

    @Transactional
    List<CommentRestaurant> findCommentRestaurantByUserId(int id);

    @Transactional
    List<CommentRestaurant> findCommentRestaurantByRestaurantId(int id);
}
