package model;

import java.util.ArrayList;
import java.util.List;

public class Franchise {

	private List<Restaurant> restaurants = new ArrayList<Restaurant>();
<<<<<<< HEAD
	private List<Order> ordersToTransmit = new ArrayList<Order>();
	
	private Double salesFigures = 0.0;
=======
>>>>>>> 594099a (correction git)

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
<<<<<<< HEAD
    
    public void manageOrders() {
    	for(Restaurant r : restaurants) {
    		for(Order o : r.getOrdersToTransmit()) {
		    	if(o.isOrderToTransmit()) ordersToTransmit.add(o);
    		}
    	}
    }
    
    public void transmitOrderToCops() {
    	manageOrders();
    	for(Order o : ordersToTransmit) {
    		o.transmitToCops();
    	}
    	ordersToTransmit.clear();
    }

    public Double getSalesFigures() {
        for(Restaurant r : restaurants) {
        	salesFigures += r.getSalesFigures();
        }
=======

    public Double getSalesFigures() {
    	Double salesFigures = 0.0;
        for(Restaurant r : restaurants) salesFigures += r.getSalesFigures();
>>>>>>> 594099a (correction git)
        return salesFigures;
    }
    
    public void addDish(Dish dish) {
    	menu.add(dish);
    	for(Restaurant r : restaurants) {
    		r.addMenu(dish);
    	}
    }
}