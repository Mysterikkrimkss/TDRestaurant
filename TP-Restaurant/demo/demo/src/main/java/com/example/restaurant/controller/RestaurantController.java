package com.example.restaurant.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.http.ResponseEntity;

import com.example.restaurant.model.Restaurant;
import com.example.restaurant.model.Table;
import com.example.restaurant.model.CustomResponseBody;

public class RestaurantController {

    @Autowired
    private RestaurantController service;

    @SuppressWarnings({ "unchecked", "rawtypes" })
	@PostMapping("/takeTable")
    public ResponseEntity<Restaurant> takeTable(@RequestBody Restaurant restaurant, @RequestBody Table table){

        try {
        	int nbTableAvailable = restaurant.getNumberTableAvailable();
        	
            if ( nbTableAvailable > 0 ) {
            	
            	service.takeTable(restaurant, table);

                CustomResponseBody response = new CustomResponseBody(201, "Created", "", "/bookTrain");
                return new ResponseEntity(response, HttpStatus.CREATED); // CREATED
            }
            else {
                CustomResponseBody response = new CustomResponseBody(409, "Conflict",
                        "The number of places requested exceeds the number of places available in this train",
                        "/takeTable");
                return new ResponseEntity(response, HttpStatus.CONFLICT); //NOT CREATED
            }


        } catch (Exception e) {
            CustomResponseBody response = new CustomResponseBody(500,"Internal Server Error", "This booktrain could not be added","/bookTrain");
            return new ResponseEntity(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
