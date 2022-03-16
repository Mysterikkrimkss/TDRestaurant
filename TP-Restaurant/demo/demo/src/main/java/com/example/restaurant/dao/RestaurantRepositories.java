package com.example.restaurant.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.example.restaurant.model.Restaurant;

@RepositoryRestResource
public interface RestaurantRepositories extends JpaRepository<Restaurant, Integer> {
}
