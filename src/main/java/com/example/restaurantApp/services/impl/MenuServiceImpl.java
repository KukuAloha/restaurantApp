package com.example.restaurantApp.services.impl;

import com.example.restaurantApp.bucket.BucketName;
import com.example.restaurantApp.domain.Menu;

import com.example.restaurantApp.domain.Restaurant;
import com.example.restaurantApp.filestore.FileStore;
import com.example.restaurantApp.repository.MenuRepository;
import com.example.restaurantApp.repository.RestaurantRepository;
import com.example.restaurantApp.services.MenuService;

import org.apache.http.entity.ContentType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import org.hibernate.Session;
import org.springframework.web.multipart.MultipartFile;

import javax.transaction.Transactional;
import java.io.IOException;
import java.util.*;

@Service
public class MenuServiceImpl implements MenuService {
    @Autowired
    private MenuRepository menuRepository;
    @Autowired
    private RestaurantRepository restaurantRepository;

    @Autowired
    FileStore fileStore;

    @Override
    public List<Menu> getMenuByRestaurantId(int id) {
        return menuRepository.findMenusByRestaurantId(id);
    }

    @Override
    @Transactional
    public void addMenu(Menu menu, int id) {
        menu.setRestaurant(restaurantRepository.getRestaurantById(id));
        menuRepository.save(menu);
    }

    public List<Menu> getAllMenus() {
        return (List<Menu>) menuRepository.findAll();
    };

    @Override
    public int deleteMenu(int id) {
        menuRepository.deleteById(id);
        return id;
    }

    @Override
    public void uploadMenuImage(int menuId, MultipartFile file) {
        isFileEmpty(file);

        isImage(file);

        Menu menu = getMenuOrThrow(menuId);

        Map<String, String> metadata = extractMetadata(file);

        String path = String.format("%s/%s/%s", BucketName.PROFILE_IMAGE.getBucketName(), "Menus", menu.getId());
        String filename = String.format("%s", file.getOriginalFilename());

        try {
            fileStore.save(path, filename, Optional.of(metadata), file.getInputStream());
            String link = "https://kray-bucket.s3.eu-central-1.amazonaws.com/Menus/" + menuId + "/" + filename;
            menuRepository.updateMenuLinkById(menuId,link);
        } catch (IOException e) {
            throw new IllegalStateException(e);
        }
    }
    private Map<String, String> extractMetadata(MultipartFile file) {
        Map<String, String> metadata = new HashMap<>();
        metadata.put("Content-Type", file.getContentType());
        metadata.put("Content-Length", String.valueOf(file.getSize()));
        return metadata;
    }

    private Menu getMenuOrThrow(int menuId) {
        return getAllMenus()
                .stream()
                .filter(menu -> menu.getId() == menuId )
                .findFirst()
                .orElseThrow(() -> new IllegalStateException(String.format("Menu %s not found", menuId)));
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
