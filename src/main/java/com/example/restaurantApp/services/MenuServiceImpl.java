package com.example.restaurantApp.services;

import com.example.restaurantApp.domain.Menu;
import com.example.restaurantApp.repository.MenuRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class MenuServiceImpl implements MenuService {
    @Autowired
    private MenuRepository menuRepository;

    @Override
    public List<Menu> getAllMenu() {
        return (List<Menu>) menuRepository.findAll();
    }

    @Override
    public int addMenu(Menu menu) {
        return menuRepository.save(menu).getId();
    }
}
