package com.example.service;

import java.util.Arrays;
import java.util.HashSet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.model.Role;
import com.example.model.User;
import com.example.model.Vehicle;
import com.example.repository.UserRepository;
import com.example.repository.VehicleRepository;
import com.example.model.Order;
import com.example.repository.OrderRepository;

@Service("orderSevice")
public class OrderServiceImpl implements OrderService {

	@Autowired
	private OrderRepository orderRepository;
	
	
	
	@Override
	public Order findOrderbyId(int orderId) {
		// TODO Auto-generated method stub
		
		return orderRepository.findByOrderId(orderId);
		
	}

	@Override
	public void saveOrder(User user, Order order, Vehicle vehicle) {
		// TODO Auto-generated method stub
		

		orderRepository.save(order);
		

	}

}