package modelTest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import model.Dish;
import model.Franchise;
import model.Order;
import model.Restaurant;
import model.Server;

public class RestaurantTest {
	
	//COMMANDES IMPAYEES
	
	@Test
	public void manageOrderNotInitTest() {
		//Arrange
		Restaurant restaurant = new Restaurant();
		Server server = new Server();
		Dish dish = new Dish();
		
		//Act
		dish.setPrice(20.0);
		dish.setStock(10);
		
		Order order = new Order(dish);
		
		order.toTransmitToCops();
		server.takeOrder(order);
		
		//Assert
		Assertions.assertNotEquals(server.getOrdersToTransmit(), new ArrayList<>());
		Assertions.assertEquals(restaurant.getOrdersToTransmit(), new ArrayList<>());
	}
	
	@Test
	public void manageOrderTest() {
		//Arrange
		Restaurant restaurant = new Restaurant();
		Server server = new Server();
		Dish dish = new Dish();
		
		//Act
		restaurant.addServer(server);
		
		dish.setPrice(20.0);
		dish.setStock(10);
		
		Order order = new Order(dish);
		
		order.toTransmitToCops();
		server.takeOrder(order);
		
		//Assert
		Assertions.assertNotEquals(server.getOrdersToTransmit(), new ArrayList<>());
		Assertions.assertNotEquals(restaurant.getOrdersToTransmit(), new ArrayList<>());
	}
	
	@Test
	public void manageTransmitOrderTest() {
		//Arrange
		Restaurant restaurant = new Restaurant();
		Server server = new Server();
		Dish dish = new Dish();
		
		//Act
		restaurant.addServer(server);
		
		dish.setPrice(20.0);
		dish.setStock(10);
		
		Order order = new Order(dish);
		
		order.toTransmitToCops();
		server.takeOrder(order);
		
		restaurant.transmitOrderToCops();
		
		//Assert
		Assertions.assertEquals(server.getOrdersToTransmit(), new ArrayList<>());
		Assertions.assertEquals(restaurant.getOrdersToTransmit(), new ArrayList<>());
	}
	
	//CHIFFRE AFFAIRES
	
	@Test
	public void manageSalesFiguresNotInitTest() {
		//Arrange
		Restaurant restaurant = new Restaurant();
		Server server = new Server();
		Dish dish = new Dish();
		
		//Act
		dish.setPrice(20.0);
		dish.setStock(10);
		server.takeOrder(dish);
		
		//Assert
		Assertions.assertEquals(server.getSalesFigures(), 20.0);
		Assertions.assertEquals(restaurant.getSalesFigures(), 0.0);
	}
	
	@Test
	public void manageSalesFiguresTest() {
		//Arrange
		Restaurant restaurant = new Restaurant();
		Server server = new Server();
		Dish dish = new Dish();
		
		//Act
		restaurant.addServer(server);
		
		dish.setPrice(20.0);
		dish.setStock(10);
		server.takeOrder(dish);
		
		//Assert
		Assertions.assertEquals(server.getSalesFigures(), 20.0);
		Assertions.assertEquals(restaurant.getSalesFigures(), 20.0);
	}
}
