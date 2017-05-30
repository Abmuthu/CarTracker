package com.muthukumaranpk.controller;

import com.muthukumaranpk.entity.Alert;
import com.muthukumaranpk.entity.Reading;
import com.muthukumaranpk.service.AlertService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by muthukumaran on 5/30/17.
 */

@RestController
@CrossOrigin(origins = "http://mocker.egen.io", maxAge = 3600)
public class AlertController {
    @Autowired
    private AlertService alertService;


    @RequestMapping(value = "/alerts",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public List<Alert> getAlerts() {
        return alertService.getHighPriorityAlerts();
    }
}