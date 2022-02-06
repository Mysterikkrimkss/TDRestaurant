package model;

import java.util.ArrayList;
import java.util.List;

public class Server {

	private String nom;
	private Double salary;
    private Double salesFigures = 0.0;
    
    private Restaurant restaurant;
    
	private List<Table> tables = new ArrayList<>();
    
    private List<Order> orders = new ArrayList<>();
    
    private List<Order> ordersToTransmit = new ArrayList<>();

    public Boolean takeOrder(Dish dish) {
    	Order order = new Order(dish);
    	if(order.isInStock()) {
	    	orders.add(order);
	        salesFigures += dish.getPrice();
	        restaurant.manageOrder(order);
	        return true;
    	}
    	return false;
    }

    public Server() {
    	
    }
    
    public Server(String nom, Double salary) {
    	this.nom = nom;
    	this.salary = salary;
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
}
