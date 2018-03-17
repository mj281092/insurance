package com.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.model.Vehicle;

@Repository("VehicleRepository")
public interface VehicleRepository extends JpaRepository<Vehicle, Integer> {
	
	Vehicle findByVehicleRegno(String regno);

}
