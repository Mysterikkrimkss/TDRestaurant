package modelTest;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import model.Dish;
import model.Kitchen;
import model.Restaurant;
import model.Server;
import model.Table;

public class KitchenTest {
	
	@Test
	public void prepareDishTest() {
		Kitchen kitchen = new Kitchen();
		Restaurant restaurant = new Restaurant();
		Server server = new Server();
		Dish dish = new Dish();
		Table table = new Table();
		
		restaurant.setKitchen(kitchen);
		restaurant.addTable(table);
		restaurant.addServer(server);
		
		dish.setStock(1);
		
		kitchen.prepareDish(server, table, dish);
		
		Assertions.assertNotEquals(table.getDishes(), new ArrayList<>());
	}	
	
//	private List<Order> tasksToDo = new ArrayList<>();
//
//	public void add(Order order) {
//		tasksToDo.add(order);
//	}
//	
//	public void prepareDish(Server server, Table table, Dish dish) {
//		if(dish.decrementStockAmount()) {
//			ringServer(server, table, dish);
//		}
//	}
//	
//	public void ringServer(Server server, Table table, Dish dish) {
//		server.serveDish(table, dish);
//	}
}
