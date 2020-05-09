package com.example.restaurantApp.repository;

import com.example.restaurantApp.domain.Menu;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface MenuRepository extends CrudRepository<Menu,Integer> {

    @Transactional
    @Modifying
    @Query("update Menu set url = :link where id = :menuId")
    void updateMenuLinkById(@Param("menuId") int menuId,
                                  @Param("link") String link);

    @Transactional
    List<Menu> findMenusByRestaurantId(@Param("id") int id);

    @Transactional
    Menu findMenuById(@Param("id") int id);
}
