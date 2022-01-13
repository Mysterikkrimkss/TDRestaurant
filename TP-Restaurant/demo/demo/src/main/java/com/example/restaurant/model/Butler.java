package com.example.restaurant.model;

import java.util.ArrayList;
import java.util.List;

public class Butler extends Server{

	public List<Table> tables = new ArrayList<>();
	
	public Butler(List<Table> tables) {
		super();
		this.tables = tables;
	}
}
