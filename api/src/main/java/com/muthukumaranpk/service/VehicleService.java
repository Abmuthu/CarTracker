package com.muthukumaranpk.service;

import com.muthukumaranpk.entity.Alert;
import com.muthukumaranpk.entity.Vehicle;

import java.util.List;

/**
 * Created by muthukumaran on 5/25/17.
 */
public interface VehicleService {

    List<Vehicle> createVehicles(List<Vehicle> vehicles);

    boolean isVehiclePresent(String vin);

    Vehicle getVehicle(String vin);

    List<Vehicle> getAllVehicles();

    List<Vehicle> getVehiclesWithCriticalAlerts();
}
