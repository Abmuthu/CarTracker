package com.muthukumaranpk.entity;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import java.util.Date;
import java.util.UUID;

/**
 * Created by muthukumaran on 5/30/17.
 */
@Entity
@NamedQueries({
        @NamedQuery(name = "Alert.findAllAlertsOfSingleVehicle",
                query = "SELECT alert FROM Alert alert WHERE alert.vin=:vin order by alert.timestamp"),

        @NamedQuery(name = "Alert.findCriticalAlertsInPastTwoHours",
                query = "Select alert from Alert alert where alert.timestamp > :date and alert.alertPriority = :priority")

})
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

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss")
    private Date timestamp;

    public String getVin() {
        return vin;
    }

    public void setVin(String vin) {
        this.vin = vin;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
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
