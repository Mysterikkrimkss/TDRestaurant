package com.example.restaurant.model;

import java.util.ArrayList;
import java.util.List;

public class Menu {

	private List<Dish> dishes = new ArrayList<>();
	
	public Menu(Menu menu) {
		dishes = menu.dishes;
	}
	
	public void setDishPrice(Dish dish, Double price) {
		if(dishes.contains(dish)) dish.setPrice(price);
	}
	
	public void add(Dish dish) {
		dishes.add(dish);
	}
}
