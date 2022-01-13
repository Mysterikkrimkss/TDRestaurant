package com.example.restaurant.model;

public class Table {

	private Server server;
	
//	private Customer customer;
	private Restaurant restaurant;
	
	private Boolean isFree = true;
	
	public Table( ) {}
	
	public Table(Server server) {
		this.server = server;
	}

	public Server getServer() {
		return server;
	}

	public void setServer(Server server) {
		this.server = server;
	}

	public void removeServer() {
		server = null;
	}

	public Boolean isFree() {
		return isFree;
	}

	public void setIsFree(Boolean isFree) {
		this.isFree = isFree;
	}
}
