package com.example.model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Digits;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.data.annotation.Transient;

@Entity
@Table(name = "order")
public class Order {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "order_id")
	private int orderId;
	@ManyToOne
	@JoinColumn(name="user_id")
    private User ordersUser;
	@ManyToOne
	@JoinColumn(name="vehicle_id")
    private Vehicle ordersVehicle;
	@Column(name = "order_type")
	@Digits(integer = 1, fraction=0, message = "*Please provide an integer (0-9) order type")
	@NotEmpty(message = "*Please provide an integer order type")
	private int orderType;
	@Column(name = "order_quantity")
	@Digits(integer = 1, fraction=0, message = "*Please provide an integer (0-9) order quantity")
	@NotEmpty(message = "*Please provide the order quantity")
	private int orderQuantity;
	@Column(name = "order_value")
	@Digits(integer = 5, fraction=2, message = "*Please provide the order value in Rs")
	@NotEmpty(message = "*Please provide the order value")
	private float orderValue;
	
	public int getOrderId() {
		return orderId;
	}
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
	public User getOrdersUser() {
		return ordersUser;
	}
	public void setOrdersUser(User ordersUser) {
		this.ordersUser = ordersUser;
	}
	public Vehicle getOrdersVehicle() {
		return ordersVehicle;
	}
	public void setOrdersVehicle(Vehicle ordersVehicle) {
		this.ordersVehicle = ordersVehicle;
	}
	public int getOrderType() {
		return orderType;
	}
	public void setOrderType(int orderType) {
		this.orderType = orderType;
	}
	public int getOrderQuantity() {
		return orderQuantity;
	}
	public void setOrderQuantity(int orderQuantity) {
		this.orderQuantity = orderQuantity;
	}
	public float getOrderValue() {
		return orderValue;
	}
	public void setOrderValue(float orderValue) {
		this.orderValue = orderValue;
	}
	
	
	
	
	
	
}

