package com.muthukumaranpk.repository;

import com.muthukumaranpk.entity.Alert;
import com.muthukumaranpk.entity.Reading;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.Date;
import java.util.List;

/**
 * Created by muthukumaran on 5/26/17.
 */

@Repository
public class ReadingRepositoryImpl implements ReadingRepository {

    private static int THIRTY_MINUTES = 30 * 60 * 1000;

    @PersistenceContext
    private EntityManager entityManager;


    @Override
    public Reading storeReading(Reading reading) {
        entityManager.persist(reading);
        return reading;
    }

    @Override
    public List<Reading> findReadingsOfAVehicle(String vin) {
        Session session = entityManager.unwrap(Session.class);
        Query<Reading> query = session.createNamedQuery("Reading.findReadingsOfSingleVehicle", Reading.class);
        query.setParameter("num", vin);
        query.setParameter("date", new Date(System.currentTimeMillis() - THIRTY_MINUTES));
        List<Reading> list = query.list();
        return list;
    }
}
