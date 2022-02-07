package modelTest;

import java.util.ArrayList;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import model.Franchise;
import model.Restaurant;
import model.Server;
import model.Dish;
import model.Order;

public class FranchiseTest {

	//COMMANDES IMPAYEES
	
	@Test
	public void manageOrderNotInitTest() {
		//Arrange
		Franchise franchise = new Franchise();
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
		Assertions.assertEquals(franchise.getOrdersToTransmit(), new ArrayList<>());
	}
	
	@Test
	public void manageOrderTest() {
		//Arrange
		Franchise franchise = new Franchise();
		Restaurant restaurant = new Restaurant();
		Server server = new Server();
		Dish dish = new Dish();
		
		//Act
		franchise.addRestaurant(restaurant);
		restaurant.addServer(server);
		
		dish.setPrice(20.0);
		dish.setStock(10);
		
		Order order = new Order(dish);
		
		order.toTransmitToCops();
		server.takeOrder(order);
		
		//Assert
		Assertions.assertNotEquals(server.getOrdersToTransmit(), new ArrayList<>());
		Assertions.assertNotEquals(restaurant.getOrdersToTransmit(), new ArrayList<>());
		Assertions.assertNotEquals(franchise.getOrdersToTransmit(), new ArrayList<>());
	}
	
	@Test
	public void manageTransmitOrderTest() {
		//Arrange
		Franchise franchise = new Franchise();
		Restaurant restaurant = new Restaurant();
		Server server = new Server();
		Dish dish = new Dish();
		
		//Act
		franchise.addRestaurant(restaurant);
		restaurant.addServer(server);
		
		dish.setPrice(20.0);
		dish.setStock(10);
		
		Order order = new Order(dish);
		
		order.toTransmitToCops();
		server.takeOrder(order);
		
		franchise.transmitOrderToCops();
		
		//Assert
		Assertions.assertEquals(server.getOrdersToTransmit(), new ArrayList<>());
		Assertions.assertEquals(restaurant.getOrdersToTransmit(), new ArrayList<>());
		Assertions.assertEquals(franchise.getOrdersToTransmit(), new ArrayList<>());
	}
	
	//CHIFFRE AFFAIRES
	
	@Test
	public void manageSalesFiguresNotInitTest() {
		//Arrange
		Franchise franchise = new Franchise();
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
		Assertions.assertEquals(franchise.getSalesFigures(), 0.0);
	}
	
	@Test
	public void manageSalesFiguresTest() {
		//Arrange
		Franchise franchise = new Franchise();
		Restaurant restaurant = new Restaurant();
		Server server = new Server();
		Dish dish = new Dish();
		
		//Act
		franchise.addRestaurant(restaurant);
		restaurant.addServer(server);
		
		dish.setPrice(20.0);
		dish.setStock(10);
		server.takeOrder(dish);
		
		//Assert
		Assertions.assertEquals(server.getSalesFigures(), 20.0);
		Assertions.assertEquals(restaurant.getSalesFigures(), 20.0);
		Assertions.assertEquals(franchise.getSalesFigures(), 20.0);
	}
}