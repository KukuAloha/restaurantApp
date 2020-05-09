package com.example.restaurantApp.services.impl;

import com.example.restaurantApp.bucket.BucketName;
import com.example.restaurantApp.domain.Dish;
import com.example.restaurantApp.domain.Menu;
import com.example.restaurantApp.domain.Restaurant;
import com.example.restaurantApp.filestore.FileStore;
import com.example.restaurantApp.repository.DishRepository;
import com.example.restaurantApp.repository.MenuRepository;
import com.example.restaurantApp.services.DishService;
import org.apache.http.entity.ContentType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.*;

@Service
public class DishServiceImpl implements DishService {
    @Autowired
    private DishRepository dishRepository;

    @Autowired
    private MenuRepository menuRepository;

    @Autowired
    private FileStore fileStore;

    @Override
    public List<Dish> getAllDishesByMenuId(int id) {
        return dishRepository.findDishesByMenuId(id);
    }

    @Override
    public void addDish(Dish dish, int id) {
        dish.setMenu(menuRepository.findMenuById(id));
        dishRepository.save(dish);
    }

    public List<Dish> getAllDishes() {
        return (List<Dish>) dishRepository.findAll();
    }

    @Override
    public void uploadDishImage(int dishId, MultipartFile file) {
        isFileEmpty(file);

        isImage(file);

        Dish dish = getDishOrThrow(dishId);

        Map<String, String> metadata = extractMetadata(file);

        String path = String.format("%s/%s/%s", BucketName.PROFILE_IMAGE.getBucketName(), "Dishes", dish.getId());
        String filename = String.format("%s", file.getOriginalFilename());

        try {
            fileStore.save(path, filename, Optional.of(metadata), file.getInputStream());
            String link = "https://kray-bucket.s3.eu-central-1.amazonaws.com/Dishes/" + dishId + "/" + filename;
            dishRepository.updateDishLinkById(dishId, link);
        } catch (IOException e) {
            throw new IllegalStateException(e);
        }
    }

    @Override
    public int deleteDish(int id) {
        dishRepository.deleteById(id);
        return id;
    }

    private Map<String, String> extractMetadata(MultipartFile file) {
        Map<String, String> metadata = new HashMap<>();
        metadata.put("Content-Type", file.getContentType());
        metadata.put("Content-Length", String.valueOf(file.getSize()));
        return metadata;
    }

    private Dish getDishOrThrow(int dishId) {
        return getAllDishes()
                .stream()
                .filter(dish -> dish.getId() == dishId )
                .findFirst()
                .orElseThrow(() -> new IllegalStateException(String.format("Dish %s not found", dishId)));
    }

    private void isImage(MultipartFile file) {
        if (!Arrays.asList(ContentType.IMAGE_JPEG.getMimeType(),
                ContentType.IMAGE_PNG.getMimeType(),
                ContentType.IMAGE_GIF.getMimeType()).contains(file.getContentType())) {
            throw new IllegalStateException("File must be an image [" + file.getContentType() + "]");
        }
    }

    private void isFileEmpty(MultipartFile file) {
        if (file.isEmpty()) {
            throw new IllegalStateException("Cannot upload empty file [ " + file.getSize() + "]");
        }
    }
}
