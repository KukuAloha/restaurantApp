package com.example.restaurantApp.repository;

import com.example.restaurantApp.domain.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.persistence.criteria.CriteriaBuilder;

public interface RoleRepository extends JpaRepository<Role, CriteriaBuilder.In> {
    Role findByName(String name);
}
