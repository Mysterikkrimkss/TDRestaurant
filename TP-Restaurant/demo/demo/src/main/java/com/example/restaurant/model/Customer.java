package com.example.restaurant.model;

public class Customer {

	private Table table;
	
	private Restaurant restaurant;
	
	public void enterRestaurant(Restaurant restaurant) {
		this.restaurant = restaurant;
	}
	
	public void takeTable(Table table) {
		if(table.isFree()) {
			this.table = table;
			restaurant.customerTakeTable(table);
		}
	}
	
	public void goAway() {
		table.setIsFree(true);
		restaurant.customerGoAway(table);
	}
}
