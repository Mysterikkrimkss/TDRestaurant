package model;

public class Dish {

	private Double price = 0.0;
	
<<<<<<< HEAD
	private Integer stockAmount = 0;
=======
	private Integer stockAmount;
>>>>>>> 2fb0ed95950daa3ff0ebffd8df5340890e3fc986
	
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
