package com.muthukumaranpk.repository;

import com.muthukumaranpk.entity.Alert;
import com.muthukumaranpk.service.AlertService;
import com.sun.xml.internal.bind.v2.TODO;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

/**
 * Created by muthukumaran on 5/30/17.
 */

@Repository
public class AlertRepositoryImpl implements AlertRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Alert storeAlert(Alert alert) {
        entityManager.persist(alert);
        return alert;
    }

    @Override
    public List<Alert> findAllAlertsOfAVehicle(String vin) {
        TypedQuery<Alert> query = entityManager.createNamedQuery("Alert.findAllAlertsOfSingleVehicle", Alert.class);
        query.setParameter("vin", vin);
        List<Alert> resultList = query.getResultList();
        return resultList;
    }

    @Override
    public List<Alert> findAllAlerts() {
        TypedQuery<Alert> query = entityManager.createNamedQuery("Alert.findAllAlerts", Alert.class);
        List<Alert> resultList = query.getResultList();
        return resultList;
    }

}
