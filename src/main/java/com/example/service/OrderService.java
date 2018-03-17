package com.example.service;

import com.example.model.Order_;
import com.example.model.User;
import com.example.model.Vehicle;

public interface OrderService {
		
	public Order_ findOrderbyId(int orderId);
	public void saveOrder(User user, Order_ order, Vehicle vehicle);
	
}
