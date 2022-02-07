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
<<<<<<< HEAD
		LocalDate outDate = takeDate.plusDays(15);
		Boolean isOut = outDate.isBefore(today);
		if(isOut && status!=OrderStatus.TRANSMIT_TO_COPS) {
=======
		long daysBetween = Duration.between(takeDate, today).toDays();
		if(daysBetween>14 && status!=OrderStatus.TRANSMIT_TO_COPS) {
>>>>>>> 2fb0ed95950daa3ff0ebffd8df5340890e3fc986
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
<<<<<<< HEAD
	
	public void toTransmitToCops() {
		status = OrderStatus.TO_TRANSMIT_TO_COPS;
	}
=======
>>>>>>> 2fb0ed95950daa3ff0ebffd8df5340890e3fc986

	public void transmitToCops() {
		status = OrderStatus.TRANSMIT_TO_COPS;
	}
	
	public Boolean isFood() {
		return isFood;
	}
	
	public Boolean isInStock() {
		if(status.equals(OrderStatus.NOT_IN_STOCK)) return false;
		return true;
<<<<<<< HEAD
	}	
	
	public Double getPrice() {
		Double result = 0.0;
		for(Dish dish : dishes) {
			result += dish.getPrice();
		}
		return result;
	}
	
	public void addDish(Dish dish) {
		dishes.add(dish);
	}
	
	public void setTakeDate(LocalDate date) {
		this.takeDate = date;
	}
=======
	}
	
>>>>>>> 2fb0ed95950daa3ff0ebffd8df5340890e3fc986
}
