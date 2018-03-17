package com.example.service;

import com.example.model.Order;
import com.example.model.User;
import com.example.model.Vehicle;

public interface OrderService {
		
	public Order findOrderbyId(int orderId);
	public void saveOrder(User user, Order order, Vehicle vehicle);
	
}
