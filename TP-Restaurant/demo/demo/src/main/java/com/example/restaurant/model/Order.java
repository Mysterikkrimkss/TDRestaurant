package com.example.restaurant.model;

import java.time.Duration;
import java.time.LocalDate;

public class Order {
	
	private enum OrderStatus{
		PAID,
		UNPAID,
		TO_TRANSMIT_TO_COPS,
		TRANSMIT_TO_COPS
	}
	
	private OrderStatus status;
	private Boolean pinned = false;
	private LocalDate takeDate;
	private Boolean isFood;
	
	
	public Order() {
		status = OrderStatus.UNPAID;
		pinned = true;
		takeDate = LocalDate.now();
		isFood = true;
	}
	
	public Order(Boolean isFood) {
		status = OrderStatus.UNPAID;
		pinned = true;
		takeDate = LocalDate.now();
		this.isFood = isFood;
	}
	
	public void checkOrderDate() {
		LocalDate today = LocalDate.now();
		long daysBetween = Duration.between(takeDate, today).toDays();
		if(daysBetween>14 && status!=OrderStatus.TRANSMIT_TO_COPS) {
			status = OrderStatus.TO_TRANSMIT_TO_COPS;
		}
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

	public Boolean getPinned() {
		return pinned;
	}

	public void setPinned(Boolean pinned) {
		this.pinned = pinned;
	}
}
