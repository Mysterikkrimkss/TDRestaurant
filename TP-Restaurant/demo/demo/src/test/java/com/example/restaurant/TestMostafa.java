package com.example.restaurant;

import org.junit.jupiter.api.Test;

public class priceTests {

 @Test
 @ValueSource(doubles = {20.0, 15.0})
  public void VerifyThatPriceAreEqual(Double price) throws Exception {

    Franchise franchise = new Franchise();
    Restaurant resto = new Restaurant();

    franchise.setDishPrice(price);

    assertEquals(resto.getPrice(), price);
  }

 @Test
 @ValueSource(doubles = {20.0, 15.0})
  public void VerifyThatPriceAreNotEqual(Double price) throws Exception {

    Restaurant resto = new Restaurant();
    resto.setDishPrice(price);
 
    Franchise franchise = new Franchise();
  
	assertNotEquals(franchise.getPrice(), price);
  }
}


    