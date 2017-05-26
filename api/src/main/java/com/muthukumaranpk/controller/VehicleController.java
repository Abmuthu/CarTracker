package com.muthukumaranpk.controller;

import com.muthukumaranpk.entity.Vehicle;
import com.muthukumaranpk.service.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by muthukumaran on 5/25/17.
 */
@RestController
public class VehicleController {

    @Autowired
    private VehicleService vehicleService;

    @RequestMapping(value = "/vehicles",
                    method = RequestMethod.PUT,
                    consumes = MediaType.APPLICATION_JSON_UTF8_VALUE,
                    produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public List<Vehicle> createVehicles(@RequestBody List<Vehicle> vehicles) {
//        vehicles.forEach(System.out::println);
        return vehicleService.createVehicles(vehicles);
    }


}
