package model;

import java.util.ArrayList;
import java.util.List;

public class Franchise {

	private List<Restaurant> restaurants = new ArrayList<Restaurant>();
	private List<Order> ordersToTransmit = new ArrayList<Order>();
	
	private Double salesFigures = 0.0;

	private Menu menu;
	
	public Franchise() {
		
	}
	
    public Franchise(List<Restaurant> restaurants) {
    	for(Restaurant r : restaurants) {
    		r.setMenu(new Menu(menu));
    	}
        this.restaurants = restaurants;
    }
	
	public void setDishPrice(Dish dish, Double price) {
		menu.setDishPrice(dish, price);
	}
    
    public void manageOrders() {
    	for(Restaurant r : restaurants) {
    		for(Order o : r.getOrdersToTransmit()) {
		    	if(o.isOrderToTransmit()) ordersToTransmit.add(o);
    		}
    	}
    }
    
    public void manageOrdersToTransmit() {
    	List<Order> ordersToTransmit = new ArrayList<>();
    	for(Restaurant restaurant : restaurants) {
    		ordersToTransmit.addAll(restaurant.getOrdersToTransmit());
    	}
    	this.ordersToTransmit = ordersToTransmit;
    }
    
    public void transmitOrderToCops() {
    	manageOrders();
    	for(Order o : ordersToTransmit) {
    		o.transmitToCops();
    	}
    	ordersToTransmit.clear();
    	for(Restaurant restaurant : restaurants) {
    		restaurant.clearOrderToTransmit();
    	}
    }

    public Double manageSalesFigures() {
    	salesFigures = 0.0;
        for(Restaurant r : restaurants) {
        	salesFigures += r.getSalesFigures();
        }
        return salesFigures;
    }
    
    public Double getSalesFigures() {
    	manageSalesFigures();
    	return salesFigures;
    }
    
    public void addDish(Dish dish) {
    	menu.add(dish);
    	for(Restaurant r : restaurants) {
    		r.addMenu(dish);
    	}
    }
    
    public List<Order> getOrdersToTransmit(){
    	manageOrdersToTransmit();
    	return this.ordersToTransmit;
    }
    
    public void addRestaurant(Restaurant restaurant) {
    	restaurants.add(restaurant);
    }
}