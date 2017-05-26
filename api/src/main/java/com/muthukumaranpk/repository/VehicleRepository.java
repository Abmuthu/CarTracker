package com.muthukumaranpk.repository;

import com.muthukumaranpk.entity.Vehicle;

import java.util.List;

/**
 * Created by muthukumaran on 5/25/17.
 */
public interface VehicleRepository {

    Vehicle storeVehicle(Vehicle vehicle);

    Vehicle updateVehicle(Vehicle vehicle);

    Vehicle findVehicle(String vin);

}
