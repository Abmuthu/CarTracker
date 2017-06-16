package com.muthukumaranpk.controller;

import com.muthukumaranpk.entity.Alert;
import com.muthukumaranpk.entity.Vehicle;
import com.muthukumaranpk.service.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by muthukumaran on 5/25/17.
 */
@RestController
@CrossOrigin(origins = {"http://mocker.egen.io", "http://127.0.0.1:8080"}, maxAge = 3600)
@RequestMapping(value = "vehicles")
public class VehicleController {

    @Autowired
    private VehicleService vehicleService;

    @RequestMapping(
                    method = RequestMethod.PUT,
                    consumes = MediaType.APPLICATION_JSON_UTF8_VALUE,
                    produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public List<Vehicle> createVehicles(@RequestBody List<Vehicle> vehicles) {
        return vehicleService.createVehicles(vehicles);
    }

    @RequestMapping(
                    value = "getAll",
                    method = RequestMethod.GET,
                    produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public List<Vehicle> findAll() {
        return vehicleService.getAllVehicles();
    }

    @RequestMapping(value = "getCriticalAlerts",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public List<Vehicle> getAllAlertsInPastTwoHours() {
        return vehicleService.getVehiclesWithCriticalAlerts();
    }

}
