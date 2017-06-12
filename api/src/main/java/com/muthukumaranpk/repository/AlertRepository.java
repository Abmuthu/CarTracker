package com.muthukumaranpk.repository;

import com.muthukumaranpk.entity.Alert;

import java.util.List;

/**
 * Created by muthukumaran on 5/30/17.
 */
public interface AlertRepository {

    Alert storeAlert(Alert alert);

    List<Alert> findAllAlertsOfAVehicle(String vin);

    List<Alert> findAllAlerts();
}
