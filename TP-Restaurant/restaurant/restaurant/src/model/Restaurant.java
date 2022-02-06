package model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Restaurant {
	
	private Table[] tablesArrays = {new Table(), new Table(), new Table()};
	private List<Table> tables = Arrays.asList(tablesArrays);
	private List<Table> freeTables = tables;
	private List<Server> servers = new ArrayList<Server>();
	private List<Order> ordersToTransmit = new ArrayList<Order>();
	
<<<<<<< HEAD
	public double salesFigures = 0.0;
	
=======
>>>>>>> 594099a (correction git)
	private Butler butler;
	
	private Boolean serviceInProgress = false;
	
	private Menu menu;
	
	private Kitchen kitchen;

    public Restaurant(List<Server> servers) {
        this.servers = servers;
    }

    public Double getSalesFigures() {
<<<<<<< HEAD
    	for(Server s : servers) {
    		salesFigures += s.getSalesFigures();
    	}
=======
    	Double salesFigures = 0.0;
    	for(Server s : servers) salesFigures += s.getSalesFigures();
>>>>>>> 594099a (correction git)
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
<<<<<<< HEAD
//    	if(order.isOrderToTransmit()) ordersToTransmit.add(order);
    	if(order.isFood()) kitchen.add(order);
    }
    
    public void manageOrdersToTransmit() {
    	for(Server server : servers) {
    		ordersToTransmit.addAll(server.getOrdersToTransmit());
    	}
    }
    
    public void transmitOrdersToCops() {
    	manageOrdersToTransmit();
=======
    	if(order.isOrderToTransmit()) ordersToTransmit.add(order);
    	if(order.isFood()) kitchen.add(order);
    }
    
    public void transmitOrderToCops() {
>>>>>>> 594099a (correction git)
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
<<<<<<< HEAD
	
	public List<Order> getOrdersToTransmit(){
		return ordersToTransmit;
	}
	
	public List<Table> getFreeTables(){
		return freeTables;
	}
=======
>>>>>>> 594099a (correction git)
}
