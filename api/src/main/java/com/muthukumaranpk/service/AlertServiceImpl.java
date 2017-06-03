package com.muthukumaranpk.service;

import com.muthukumaranpk.entity.*;
import com.muthukumaranpk.repository.AlertRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by muthukumaran on 5/30/17.
 */

@Service
public class AlertServiceImpl implements AlertService {

    @Autowired
    private AlertRepository alertRepository;

    @Override
    public Alert createAlert(Reading reading, Vehicle vehicle) {
        Alert alert = new Alert();
        alert.setVin(reading.getVin());
        Alert returnedAlert = null;

        if (reading.getEngineRpm() > vehicle.getRedlineRpm()) {
            alert.setAlertPriority(AlertPriority.HIGH);
            alert.setAlertMessage("Engine rpm too high!");
            returnedAlert = alertRepository.storeAlert(alert);
        }

        if (reading.getFuelVolume() < (0.1 * vehicle.getMaxFuelVolume())) {
            alert.setAlertPriority(AlertPriority.MEDIUM);
            alert.setAlertMessage("Low Fuel");
            returnedAlert = alertRepository.storeAlert(alert);
        }

        if (isTireFaulty(reading.getTires())) {
            alert.setAlertPriority(AlertPriority.LOW);
            alert.setAlertMessage("Flat Tire!");
            returnedAlert = alertRepository.storeAlert(alert);
        }

        if (reading.isEngineCoolantLow() || reading.isCheckEngineLightOn()) {
            alert.setAlertPriority(AlertPriority.LOW);
            alert.setAlertMessage("Check engine coolant and light!");
            returnedAlert = alertRepository.storeAlert(alert);
        }

        return returnedAlert;
    }

    @Override
    public List<Alert> getHighPriorityAlerts() {
        return alertRepository.findAlerts();
    }

    private boolean isTireFaulty(Tires tires) {
        int frontLeft = tires.getFrontLeft();
        int frontRight = tires.getFrontRight();
        int rearLeft =  tires.getRearLeft();
        int rearRight = tires.getRearRight();

        return ((frontLeft < 32 || frontLeft > 36) || (frontRight < 32 || frontRight > 36)
                || (rearLeft < 32 || rearLeft > 36) || (rearRight < 32 || rearRight > 36));
    }
}
