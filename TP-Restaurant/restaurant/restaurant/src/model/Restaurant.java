package model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Restaurant {
	
//	private Table[] tablesArrays = {new Table(), new Table(), new Table()};
	private List<Table> tables = new ArrayList<>();
	private List<Table> freeTables = tables;
	private List<Server> servers = new ArrayList<Server>();
	private List<Order> ordersToTransmit = new ArrayList<Order>();
	
	public double salesFigures = 0.0;
	
	private Butler butler;
	
	private Boolean serviceInProgress = false;
	
	private Menu menu = new Menu();
	
	private Kitchen kitchen = new Kitchen();

    public Restaurant(List<Server> servers) {
        this.servers = servers;
    }

    public Restaurant() {
		// TODO Auto-generated constructor stub
	}

	public void manageSalesFigures() {
		Double salesFigures = 0.0;
    	for(Server s : servers) {
    		salesFigures += s.getSalesFigures();
    	}
    	this.salesFigures = salesFigures;
    }
	
	public Double getSalesFigures() {
		manageSalesFigures();
		return salesFigures;
	}
    
    public void serverTakeTable(Server server, Table table) {
    	if(!serviceInProgress) {
    		server.takeTable(table);
    	}
    }
    
    public void startService() {
    	for(Table t : tables) {
    		if(t.getServer() == null) {
    			butler.takeTable(t);
    		}
    	}
    	serviceInProgress = true;
    }
    
    public void endService() {
    	serviceInProgress = false;
    }
    
    public void manageOrder(Order order) {
//    	if(order.isOrderToTransmit()) ordersToTransmit.add(order);
    	if(order.isFood()) kitchen.add(order);
    }
    
    public void manageOrdersToTransmit() {
    	List<Order> ordersToTransmit = new ArrayList<>();
    	for(Server server : servers) {
    		ordersToTransmit.addAll(server.getOrdersToTransmit());
    	}
    	this.ordersToTransmit = ordersToTransmit;
    }
    
    public void transmitOrdersToCops() {
    	manageOrdersToTransmit();
    	for(Order o : ordersToTransmit) {
    		o.transmitToCops();
    	}
    	ordersToTransmit.clear();
    }

	public void addMenu(Dish dish) {
		menu.add(dish);		
	}

	public Menu getMenu() {
		return menu;
	}

	public void setMenu(Menu menu) {
		this.menu = menu;
	}
	
	public List<Order> getOrdersToTransmit(){
		manageOrdersToTransmit();
		return ordersToTransmit;
	}
	
	public List<Table> getFreeTables(){
		return freeTables;
	}
	
	public void addServer(Server server) {
		servers.add(server);
		server.setRestaurant(this);
	}

	public void clearOrderToTransmit() {
		ordersToTransmit.clear();
		for(Server server : servers) {
			server.clearOrdersToTransmit();
		}
	}

	public void transmitOrderToCops() {
    	manageOrdersToTransmit();
    	for(Order o : ordersToTransmit) {
    		o.transmitToCops();
    	}
    	clearOrderToTransmit();		
	}
	
	public void setKitchen(Kitchen kitchen) {
		this.kitchen = kitchen;
	}

	public void addTable(Table table) {
		tables.add(table);		
	}
}
