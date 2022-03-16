package modelTest;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import model.Dish;
import model.Order;
import model.Restaurant;
import model.Server;

public class ServerTest {

	//COMMANDES IMPAYEES
	
	@Test
	public void manageOrderNotInitTest() {
		//Arrange
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
	}
	
	@Test
	public void manageOrderTest() {
		//Arrange
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
	}
	
	@Test
	public void manageTransmitOrderTest() {
		//Arrange
		Server server = new Server();
		Dish dish = new Dish();
		
		//Act		
		dish.setPrice(20.0);
		dish.setStock(10);
		
		Order order = new Order(dish);
		
		order.toTransmitToCops();
		server.takeOrder(order);
		
		server.transmitOrderToCops();
		
		//Assert
		Assertions.assertEquals(server.getOrdersToTransmit(), new ArrayList<>());
	}
	
	//CHIFFRE AFFAIRES
	
	@Test
	public void manageSalesFiguresNotInitTest() {
		//Arrange
		Server server = new Server();
		Dish dish = new Dish();
		
		//Act
		dish.setPrice(20.0);
		dish.setStock(10);
		server.takeOrder(dish);
		
		//Assert
		Assertions.assertEquals(server.getSalesFigures(), 20.0);
	}
	
	@Test
	public void manageSalesFiguresTest() {
		//Arrange
		Server server = new Server();
		Dish dish = new Dish();
		
		//Act		
		dish.setPrice(20.0);
		dish.setStock(10);
		server.takeOrder(dish);
		
		//Assert
		Assertions.assertEquals(server.getSalesFigures(), 20.0);
	}
}
