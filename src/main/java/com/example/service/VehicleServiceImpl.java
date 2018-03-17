package com.example.service;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.model.Order;
import com.example.model.Role;
import com.example.model.User;
import com.example.model.Vehicle;
import com.example.repository.UserRepository;
import com.example.repository.VehicleRepository;

@Service("vehicleSevice")
public class VehicleServiceImpl implements VehicleService {

	@Autowired
	private VehicleRepository vehicleRepository;
	
	
	
	@Override
	public Vehicle findVehiclebyRegno(String regno) {
		// TODO Auto-generated method stub
		
		return vehicleRepository.findByVehicleRegno(regno);
		
	}

	@Override
	public void saveVehicle(User user, Vehicle vehicle) {
		// TODO Auto-generated method stub
		/*user.setUserPassword(bCryptPasswordEncoder.encode(user.getUserPassword()));
		user.setActive(true);
		Role userRole = roleRepository.findByRole("USER");
		user.setUsersRoles(new HashSet<Role>(Arrays.asList(userRole)));
		userRepository.save(user);*/
		
		
		vehicle.setVehiclesUser(user);

		vehicleRepository.save(vehicle);
		

	}

}
