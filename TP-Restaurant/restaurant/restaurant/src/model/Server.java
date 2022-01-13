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

    public void takeOrder(Double amount) {
    	Order order = new Order();
    	orders.add(order);
        salesFigures += amount;
        restaurant.manageOrder(order);
    }

    public Server() {
    	
    }
    
    public void stopTable(Table table) {
    	tables.remove(table);
    	table.removeServer();
    }
    
    public void takeTable(Table table) {
    	tables.add(table);
    	table.setServer(this);
    }
    
    public Server(String nom, Double salary) {
    	this.nom = nom;
    	this.salary = salary;
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
}
