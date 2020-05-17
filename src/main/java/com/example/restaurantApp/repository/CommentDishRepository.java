package com.example.restaurantApp.repository;

import com.example.restaurantApp.domain.CommentDish;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface CommentDishRepository extends CrudRepository<CommentDish, Integer> {

    @Transactional
    List<CommentDish> findCommentDishByUserId(int id);

    @Transactional
    List<CommentDish> findCommentDishByDishId(int id);
}
