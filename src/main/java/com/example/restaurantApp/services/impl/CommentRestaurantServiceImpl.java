package com.example.restaurantApp.services.impl;

import com.example.restaurantApp.domain.CommentRestaurant;
import com.example.restaurantApp.domain.Restaurant;
import com.example.restaurantApp.dto.CommentRestaurantDto;
import com.example.restaurantApp.repository.CommentRestaurantRepository;
import com.example.restaurantApp.repository.RestaurantRepository;
import com.example.restaurantApp.repository.UserRepository;
import com.example.restaurantApp.services.CommentRestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Stream;

@Service
public class CommentRestaurantServiceImpl implements CommentRestaurantService {

    @Autowired
    private CommentRestaurantRepository commentRestaurantRepository;
    @Autowired
    private RestaurantRepository restaurantRepository;
    @Autowired
    private UserRepository userRepository;

    @Override
    public List<CommentRestaurant> getAllCommentRestaurant() {
        return (List<CommentRestaurant>) commentRestaurantRepository.findAll();
    }

    @Override
    public void addCommentRestaurant(CommentRestaurantDto commentRestaurantDto, int idUser, int idRestaurant) {
        CommentRestaurant commentRestaurant = new CommentRestaurant();

        commentRestaurant.setComment(commentRestaurantDto.getComment());
        commentRestaurant.setStars(commentRestaurantDto.getStars());
        commentRestaurant.setName(userRepository.findById(idUser).get().getLogin());

        commentRestaurant.setUser(userRepository.findById(idUser).get());
        commentRestaurant.setRestaurant(restaurantRepository.findById(idRestaurant).get());
        commentRestaurantRepository.save(commentRestaurant);

        List<CommentRestaurant> comments = commentRestaurantRepository
                .findCommentRestaurantByRestaurantId(idRestaurant);

        if(!comments.isEmpty()) {
            int stars = 0;

            for (CommentRestaurant c: comments) {
                stars = stars + c.getStars();
            }

            Restaurant restaurant = restaurantRepository.getRestaurantById(idRestaurant);

            stars = (int) stars/comments.size();

            restaurant.setStars(stars);

            restaurantRepository.save(restaurant);
        }
    }

    @Override
    public List<CommentRestaurant> getAllCommentByRestaurantId(int id) {
        return commentRestaurantRepository.findCommentRestaurantByRestaurantId(id);
    }

    @Override
    public void deleteCommentRestaurant(int id) {
        commentRestaurantRepository.deleteById(id);
    }

}


