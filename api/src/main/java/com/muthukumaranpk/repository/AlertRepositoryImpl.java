package com.muthukumaranpk.repository;

import com.muthukumaranpk.entity.Alert;
import com.muthukumaranpk.entity.Reading;
import com.muthukumaranpk.service.AlertService;
import com.sun.xml.internal.bind.v2.TODO;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.Date;
import java.util.List;

/**
 * Created by muthukumaran on 5/30/17.
 */

@Repository
public class AlertRepositoryImpl implements AlertRepository {

    private static int TWO_HOURS = 2 * 60 * 60 * 1000;

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
        Session session = entityManager.unwrap(Session.class);
        Query<Alert> query = session.createQuery("from Alert where timestamp > :date");
        query.setParameter("date", new Date(System.currentTimeMillis() - TWO_HOURS));
        List<Alert> list = query.list();
        return list;
    }

}
