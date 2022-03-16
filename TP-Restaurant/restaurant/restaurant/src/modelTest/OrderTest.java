package modelTest;

import java.time.Duration;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import model.Dish;
import model.Order;

public class OrderTest {
	
	@Test
	public void getPriceTest() {
		Dish dish1 = new Dish();
		dish1.setPrice(10.0);
		Dish dish2 = new Dish();
		dish2.setPrice(25.0);
		
		Order order = new Order();
		order.addDish(dish1);
		order.addDish(dish2);
		
		Assertions.assertEquals(order.getPrice(), 35.0);
	}
	
	@Test
	public void checkOrderDateTest() {
		Order order = new Order();
		
		Assertions.assertEquals(order.checkOrderDate(), null);
	}
	
	@Test
	public void checkOrderDateLateTest() {
		Order order = new Order();
		LocalDate date = LocalDate.now().minusYears(1);
		order.setTakeDate(date);
		Assertions.assertEquals(order.checkOrderDate(), order);
	}
	
	@Test
	public void isOrderToTransmitFalseTest() {
		Order order = new Order();
		
		Assertions.assertEquals(order.isOrderToTransmit(), false);
	}
	

	
	@Test
	public void isOrderToTransmitTest() {
		Order order = new Order();
		order.toTransmitToCops();
		Assertions.assertEquals(order.isOrderToTransmit(), true);
	}
}
