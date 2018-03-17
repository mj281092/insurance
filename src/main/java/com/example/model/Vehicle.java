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
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.data.annotation.Transient;

@Entity
@Table(name = "vehicle")
public class Vehicle {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "vehicle_id")
	private int vehicleId;
	@ManyToOne
	@JoinColumn(name="user_id")
    private User vehiclesUser;
	@Column(name = "vehicle_regno")
	@NotEmpty(message = "*Please provide the vehicle registration number")
	private String vehicleRegno;
	@Column(name = "vehicle_modelno")
	@NotEmpty(message = "*Please provide the vehicle model number")
	private String vehicleModelno;
	@OneToMany(mappedBy="ordersVehicle", cascade = CascadeType.ALL)
	private Set<Order_> vehiclesOrders;
	
	
	
	public int getVehicleId() {
		return vehicleId;
	}
	public void setVehicleId(int vehicleId) {
		this.vehicleId = vehicleId;
	}
	public User getVehiclesUser() {
		return vehiclesUser;
	}
	public void setVehiclesUser(User vehiclesUser) {
		this.vehiclesUser = vehiclesUser;
	}
	public String getVehicleRegno() {
		return vehicleRegno;
	}
	public void setVehicleRegno(String vehicleRegno) {
		this.vehicleRegno = vehicleRegno;
	}
	public String getVehicleModelno() {
		return vehicleModelno;
	}
	public void setVehicleModelno(String vehicleModelno) {
		this.vehicleModelno = vehicleModelno;
	}
	public Set<Order_> getVehiclesOrders() {
		return vehiclesOrders;
	}
	public void setVehiclesOrders(Set<Order_> vehiclesOrders) {
		this.vehiclesOrders = vehiclesOrders;
	}
	
	public void addtoVehiclesOrders(Order_ vehiclesOrder) {
		this.vehiclesOrders.add(vehiclesOrder);
	}
	
	
	
}
