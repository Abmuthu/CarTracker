package com.muthukumaranpk.controller;

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
@CrossOrigin(origins = "http://mocker.egen.io", maxAge = 3600)
public class ReadingController {

    @Autowired
    private ReadingService readingService;

    @RequestMapping(value = "/readings",
            method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_UTF8_VALUE,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Reading createVehicles(@RequestBody Reading reading) {
        return readingService.putReading(reading);
    }

}
