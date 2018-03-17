package com.example.service;

import com.example.model.User;
import com.example.model.Vehicle;

public interface VehicleService {
		
	public Vehicle findVehiclebyRegno(String regno);
	public void saveVehicle(User user, Vehicle vehicle);
	
}
