package com.example.model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.data.annotation.Transient;

@Entity
@Table(name = "user")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "user_id")
	private int userId;
	@Column(name = "email")
	@Email(message = "*Please provide a valid Email")
	@NotEmpty(message = "*Please provide an email")
	private String userEmail;
	@Column(name = "password")
	@Length(min = 5, message = "*Your password must have at least 5 characters")
	@NotEmpty(message = "*Please provide your password")
	@Transient
	private String userPassword;
	@Column(name = "name")
	@NotEmpty(message = "*Please provide your name")
	private String userName;
	@Column(name = "last_name")
	@NotEmpty(message = "*Please provide your last name")
	private String userLastName;
	@Column(name = "active")
	private boolean active;
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "user_role", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "role_id"))
	private Set<Role> usersRoles;
	@OneToMany(mappedBy="vehiclesUser", cascade = CascadeType.ALL)
	private Set<Vehicle> usersVehicles;
	@OneToMany(mappedBy="ordersUser", cascade = CascadeType.ALL)
	private Set<Order> usersOrders;
	
	
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getUserEmail() {
		return userEmail;
	}
	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}
	public String getUserPassword() {
		return userPassword;
	}
	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserPame(String userName) {
		this.userName = userName;
	}
	public String getUserLastName() {
		return userLastName;
	}
	public void setUserLastName(String userLastName) {
		this.userLastName = userLastName;
	}
	public boolean isActive() {
		return active;
	}
	public void setActive(boolean active) {
		this.active = active;
	}
	public Set<Role> getUsersRoles() {
		return usersRoles;
	}
	public void setUsersRoles(Set<Role> usersRoles) {
		this.usersRoles = usersRoles;
	}
	public Set<Vehicle> getUsersVehicles() {
		return usersVehicles;
	}
	public void setUsersVehicles(Set<Vehicle> usersVehicles) {
		this.usersVehicles = usersVehicles;
	}
	public Set<Order> getUsersOrders() {
		return usersOrders;
	}
	public void setUsersOrders(Set<Order> usersOrders) {
		this.usersOrders = usersOrders;
	}
	
	

}
