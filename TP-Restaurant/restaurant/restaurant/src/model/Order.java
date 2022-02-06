package model;

import java.time.Duration;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Order {
	
	private enum OrderStatus{
		NOT_IN_STOCK,
		PAID,
		UNPAID,
		TO_TRANSMIT_TO_COPS,
		TRANSMIT_TO_COPS
	}
	
	private OrderStatus status;
	private Boolean pinned = false;
	private LocalDate takeDate;
	private Boolean isFood;
	
	private List<Dish> dishes = new ArrayList<>();
	
	
	public Order() {
		status = OrderStatus.UNPAID;
		pinned = true;
		takeDate = LocalDate.now();
		isFood = true;
	}
	
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
	
	public Boolean isInStock() {
		if(status.equals(OrderStatus.NOT_IN_STOCK)) return false;
		return true;
	}
	
}
