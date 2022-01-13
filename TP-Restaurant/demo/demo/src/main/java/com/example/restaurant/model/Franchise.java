package com.example.restaurant.model;

import java.util.ArrayList;
import java.util.List;

public class Franchise {

	private List<Restaurant> restaurants = new ArrayList<Restaurant>();

	private Menu menu;
	
	public void setDishPrice(Dish dish, Double price) {
		menu.setDishPrice(dish, price);
	}
	
    public Franchise(List<Restaurant> restaurants) {
    	for(Restaurant r : restaurants) {
    		r.setMenu(new Menu(menu));
    	}
        this.restaurants = restaurants;
    }

    public Double getSalesFigures() {
    	Double salesFigures = 0.0;
        for(Restaurant r : restaurants) salesFigures += r.getSalesFigures();
        return salesFigures;
    }
    
    public void addDish(Dish dish) {
    	menu.add(dish);
    	for(Restaurant r : restaurants) {
    		r.addMenu(dish);
    	}
    }
}