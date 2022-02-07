package model;

import java.util.ArrayList;
import java.util.List;

public class Franchise {

	private List<Restaurant> restaurants = new ArrayList<Restaurant>();
	private List<Order> ordersToTransmit = new ArrayList<Order>();
	
	private Double salesFigures = 0.0;

	private Menu menu;
	
<<<<<<< HEAD
	public Franchise() {
		
=======
	public void setDishPrice(Dish dish, Double price) {
		menu.setDishPrice(dish, price);
>>>>>>> 2fb0ed95950daa3ff0ebffd8df5340890e3fc986
	}
	
    public Franchise(List<Restaurant> restaurants) {
    	for(Restaurant r : restaurants) {
    		r.setMenu(new Menu(menu));
    	}
        this.restaurants = restaurants;
    }
<<<<<<< HEAD
	
	public void setDishPrice(Dish dish, Double price) {
		menu.setDishPrice(dish, price);
	}
=======
>>>>>>> 2fb0ed95950daa3ff0ebffd8df5340890e3fc986
    
    public void manageOrders() {
    	for(Restaurant r : restaurants) {
    		for(Order o : r.getOrdersToTransmit()) {
		    	if(o.isOrderToTransmit()) ordersToTransmit.add(o);
    		}
    	}
    }
    
<<<<<<< HEAD
    public void manageOrdersToTransmit() {
    	List<Order> ordersToTransmit = new ArrayList<>();
    	for(Restaurant restaurant : restaurants) {
    		ordersToTransmit.addAll(restaurant.getOrdersToTransmit());
    	}
    	this.ordersToTransmit = ordersToTransmit;
    }
    
=======
>>>>>>> 2fb0ed95950daa3ff0ebffd8df5340890e3fc986
    public void transmitOrderToCops() {
    	manageOrders();
    	for(Order o : ordersToTransmit) {
    		o.transmitToCops();
    	}
    	ordersToTransmit.clear();
<<<<<<< HEAD
    	for(Restaurant restaurant : restaurants) {
    		restaurant.clearOrderToTransmit();
    	}
    }

    public Double manageSalesFigures() {
    	salesFigures = 0.0;
=======
    }

    public Double getSalesFigures() {
>>>>>>> 2fb0ed95950daa3ff0ebffd8df5340890e3fc986
        for(Restaurant r : restaurants) {
        	salesFigures += r.getSalesFigures();
        }
        return salesFigures;
    }
    
<<<<<<< HEAD
    public Double getSalesFigures() {
    	manageSalesFigures();
    	return salesFigures;
    }
    
=======
>>>>>>> 2fb0ed95950daa3ff0ebffd8df5340890e3fc986
    public void addDish(Dish dish) {
    	menu.add(dish);
    	for(Restaurant r : restaurants) {
    		r.addMenu(dish);
    	}
    }
<<<<<<< HEAD
    
    public List<Order> getOrdersToTransmit(){
    	manageOrdersToTransmit();
    	return this.ordersToTransmit;
    }
    
    public void addRestaurant(Restaurant restaurant) {
    	restaurants.add(restaurant);
    }
=======
>>>>>>> 2fb0ed95950daa3ff0ebffd8df5340890e3fc986
}