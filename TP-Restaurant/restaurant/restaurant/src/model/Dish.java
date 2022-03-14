package model;

public class Dish {

	private Double price = 0.0;
	
	private Integer stockAmount;
	
	public void setPrice(Double price) {
		this.price = price;
	}
	
	public void setStock(Integer amount) {
		this.stockAmount = amount;
	}
	
	public Boolean decrementStockAmount() {
		if(stockAmount>0) {
			stockAmount--;
			return true;
		}
		return false;
	}
	
	public Double getPrice() {
		return price;
	}
}
