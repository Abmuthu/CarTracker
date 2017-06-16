package com.muthukumaranpk.controller;

import com.muthukumaranpk.entity.Alert;
import com.muthukumaranpk.entity.Reading;
import com.muthukumaranpk.entity.Vehicle;
import com.muthukumaranpk.service.ReadingService;
import com.muthukumaranpk.service.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by muthukumaran on 5/26/17.
 */
@RestController
@CrossOrigin(origins = {"http://mocker.egen.io", "http://127.0.0.1:8080"}, maxAge = 3600)
@RequestMapping(value = "readings")
public class ReadingController {

    @Autowired
    private ReadingService readingService;

    @RequestMapping(method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_UTF8_VALUE,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Reading createVehicles(@RequestBody Reading reading) {
        return readingService.putReading(reading);
    }

    @RequestMapping(value = "{vin}",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public List<Reading> getReadingsOfAVehicle(@PathVariable("vin") String vin) {
        return readingService.getReadingsInTimeRange(vin, 30);
    }

    @RequestMapping(value="{vin}/{timeRange}",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public List<Reading> getReadingsInTimeRange(@PathVariable("vin") String vin, @PathVariable("timeRange") int timeRange) {
        return readingService.getReadingsInTimeRange(vin, timeRange);
    }



}
