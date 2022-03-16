package com.example.restaurant.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.restaurant.dao.RestaurantRepositories;
import com.example.restaurant.model.Restaurant;
import com.example.restaurant.model.Table;

public class RestaurantService {
	  @Autowired
	    private RestaurantRepositories repository;

	    public void takeTable(Restaurant restaurant, Table table) {
	    	restaurant.customerTakeTable(table);
	    }
	    
	    public Restaurant addRestaurant(Restaurant restaurant){
	        return repository.save(restaurant);

	    }

	    public List<Restaurant> addRestaurants(List<Restaurant> restaurants){
	        return repository.saveAll(restaurants);
	    }

	    public Restaurant getRestaurantById(int id){
	        return repository.findById(id).orElse(null);
	    }

	    public List<Restaurant> getRestaurants(){
	        return repository.findAll();
	    }

	    public String deleteRestaurant(int id){

	        if ( repository.existsById(id) ) {
	            repository.deleteById(id);
	            return "success";
	        }
	        else {
	            return "not exists";
	        }

	    }
}
