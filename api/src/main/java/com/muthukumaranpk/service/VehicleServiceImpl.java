package com.muthukumaranpk.service;

import com.muthukumaranpk.entity.Vehicle;
import com.muthukumaranpk.repository.VehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by muthukumaran on 5/25/17.
 */

@Service
public class VehicleServiceImpl implements VehicleService {

    @Autowired
    private VehicleRepository vehicleRepository;

    @Override
    @Transactional
    public List<Vehicle> createVehicles(List<Vehicle> vehicles) {
        System.out.println("Create vehicles called");
        List<Vehicle> persistedVehicles = new ArrayList<>();

        for (Vehicle vehicle : vehicles) {
            if(isVehiclePresent(vehicle.getVin())) {
                System.out.println("create");
                persistedVehicles.add(vehicleRepository.storeVehicle(vehicle));
            } else {
                // validate service date
                System.out.println("update");
                persistedVehicles.add(vehicleRepository.updateVehicle(vehicle));
            }
        }

        return persistedVehicles;
    }

    @Override
    public boolean isVehiclePresent(String vin) {
        return vehicleRepository.findVehicle(vin) == null;
    }
}
