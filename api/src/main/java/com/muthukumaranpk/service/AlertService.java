package com.muthukumaranpk.service;

import com.muthukumaranpk.entity.Alert;
import com.muthukumaranpk.entity.Reading;
import com.muthukumaranpk.entity.Vehicle;

import java.util.List;

/**
 * Created by muthukumaran on 5/30/17.
 */
public interface AlertService {

    Alert createAlert(Reading reading, Vehicle vehicle);

    List<Alert> getHighPriorityAlerts();
}
