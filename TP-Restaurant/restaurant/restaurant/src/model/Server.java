package model;

import java.util.ArrayList;
import java.util.List;

public class Server {

	private String nom;
	private Double salary;
    private Double salesFigures = 0.0;
    
    private Restaurant restaurant = new Restaurant();
    
	private List<Table> tables = new ArrayList<>();
    
    private List<Order> orders = new ArrayList<>();
    
    private List<Order> ordersToTransmit = new ArrayList<>();

    public Server() {
    	
    }
    
    public Server(String nom, Double salary) {
    	this.nom = nom;
    	this.salary = salary;
    }
    
    public Boolean takeOrder(Dish dish) {
    	Order order = new Order(dish);
    	if(order.isInStock()) {
	    	orders.add(order);
	        salesFigures += dish.getPrice();
	        manageOrder(order);
	        return true;
    	}
    	return false;
    }
    
    public Boolean takeOrder(Order order) {
    	if(order.isInStock()) {
	    	orders.add(order);
	        salesFigures += order.getPrice();
	        manageOrder(order);
	        return true;
    	}
    	return false;
    }
    
    public void manageOrder(Order order) {
    	if(order.isOrderToTransmit()) {
    		ordersToTransmit.add(order);
    	}
        restaurant.manageOrder(order);
    }
    
    public void stopTable(Table table) {
    	tables.remove(table);
    	table.removeServer();
    }
    
    public void takeTable(Table table) {
    	tables.add(table);
    	table.setServer(this);
    }
    
    public void serveDish(Table table, Dish dish) {
    	table.takeDish(dish);
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}
	
	public void setRestaurant(Restaurant restaurant) {
		this.restaurant = restaurant;
	}

	public Double getSalary() {
		return salary;
	}

	public void setSalary(Double salary) {
		this.salary = salary;
	}

	public Double getSalesFigures() {
		return salesFigures;
	}

	public void setSalesFigures(Double salesFigures) {
		this.salesFigures = salesFigures;
	}  
	
	public List<Order> getOrdersToTransmit() {
		return this.ordersToTransmit;
	}

	public void clearOrdersToTransmit() {
		ordersToTransmit.clear();
		
	}

	public void transmitOrderToCops() {
    	for(Order o : ordersToTransmit) {
    		o.transmitToCops();
    	}
    	clearOrdersToTransmit();				
	}  
}
