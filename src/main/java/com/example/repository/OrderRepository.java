package com.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.model.Order_;


@Repository("orderRepository")
public interface OrderRepository extends JpaRepository<Order_, Integer> {
	
	Order_ findByOrderId(int orderId);

}
