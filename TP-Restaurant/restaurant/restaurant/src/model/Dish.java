package model;

public class Dish {

	private Double price = 0.0;
	
<<<<<<< HEAD
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
=======
	public void setPrice(Double price) {
		this.price = price;
	}
>>>>>>> 594099a (correction git)
}
