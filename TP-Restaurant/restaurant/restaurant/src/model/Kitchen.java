package model;

import java.util.ArrayList;
import java.util.List;

public class Kitchen {

	private List<Order> tasksToDo = new ArrayList<>();

	public void add(Order order) {
		tasksToDo.add(order);
	}
	
	public void prepareDish(Server server, Table table, Dish dish) {
		if(dish.decrementStockAmount()) {
			ringServer(server, table, dish);
		}
	}
	
	public void ringServer(Server server, Table table, Dish dish) {
		server.serveDish(table, dish);
	}
}
