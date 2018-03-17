package com.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.model.Order;


@Repository("OrderRepository")
public interface OrderRepository extends JpaRepository<Order, Integer> {
	
	Order findByOrderId(int orderId);

}
