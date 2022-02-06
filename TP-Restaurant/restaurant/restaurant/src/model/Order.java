package model;

import java.time.Duration;
import java.time.LocalDate;
<<<<<<< HEAD
import java.util.ArrayList;
import java.util.List;
=======
>>>>>>> 594099a (correction git)

public class Order {
	
	private enum OrderStatus{
<<<<<<< HEAD
		NOT_IN_STOCK,
=======
>>>>>>> 594099a (correction git)
		PAID,
		UNPAID,
		TO_TRANSMIT_TO_COPS,
		TRANSMIT_TO_COPS
	}
	
	private OrderStatus status;
	private Boolean pinned = false;
	private LocalDate takeDate;
	private Boolean isFood;
	
<<<<<<< HEAD
	private List<Dish> dishes = new ArrayList<>();
	
=======
>>>>>>> 594099a (correction git)
	
	public Order() {
		status = OrderStatus.UNPAID;
		pinned = true;
		takeDate = LocalDate.now();
		isFood = true;
	}
	
<<<<<<< HEAD
	public Order(Dish dish) {
		if(dish.decrementStockAmount()) {
			status = OrderStatus.UNPAID;
			pinned = true;
			takeDate = LocalDate.now();
			dishes.add(dish);
			isFood = true;
		}else {
			status = OrderStatus.NOT_IN_STOCK;
		}
	}
	
=======
>>>>>>> 594099a (correction git)
	public Order(Boolean isFood) {
		status = OrderStatus.UNPAID;
		pinned = true;
		takeDate = LocalDate.now();
		this.isFood = isFood;
	}
	
	public Order checkOrderDate() {
		LocalDate today = LocalDate.now();
		long daysBetween = Duration.between(takeDate, today).toDays();
		if(daysBetween>14 && status!=OrderStatus.TRANSMIT_TO_COPS) {
			status = OrderStatus.TO_TRANSMIT_TO_COPS;
			return this;
		}
		return null;
	}
	
	public Boolean isOrderToTransmit() {
		checkOrderDate();
		if(status == OrderStatus.TO_TRANSMIT_TO_COPS) return true;
		return false;
	}

	public void transmitToCops() {
		status = OrderStatus.TRANSMIT_TO_COPS;
	}
	
	public Boolean isFood() {
		return isFood;
	}
	
<<<<<<< HEAD
	public Boolean isInStock() {
		if(status.equals(OrderStatus.NOT_IN_STOCK)) return false;
		return true;
	}
	
=======
>>>>>>> 594099a (correction git)
}
