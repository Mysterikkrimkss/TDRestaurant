package model;

import java.util.ArrayList;
import java.util.List;

public class Table {

	private Server server;
	
	private Customer customer;
	
	private List<Dish> dishes = new ArrayList<>();
	
	public Table( ) {}
	
	public Table(Server server) {
		this.server = server;
	}
	
	public void takeDish(Dish dish) {
		dishes.add(dish);
	}

	public Server getServer() {
		return server;
	}

	public void setServer(Server server) {
		this.server = server;
	}

	public void removeServer() {
		server = null;
	}
}
