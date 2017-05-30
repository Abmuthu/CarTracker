package com.muthukumaranpk.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.UUID;

/**
 * Created by muthukumaran on 5/30/17.
 */
@Entity
public class Alert {

    @Id
    @Column(columnDefinition = "varchar(36)")
    private String id;

    public Alert() {
        this.id = UUID.randomUUID()
                .toString();
    }

    private String vin;
    private AlertPriority alertPriority;
    private String alertMessage;

    public String getVin() {
        return vin;
    }

    public void setVin(String vin) {
        this.vin = vin;
    }

    public AlertPriority getAlertPriority() {
        return alertPriority;
    }

    public void setAlertPriority(AlertPriority alertPriority) {
        this.alertPriority = alertPriority;
    }

    public String getAlertMessage() {
        return alertMessage;
    }

    public void setAlertMessage(String alertMessage) {
        this.alertMessage = alertMessage;
    }
}
