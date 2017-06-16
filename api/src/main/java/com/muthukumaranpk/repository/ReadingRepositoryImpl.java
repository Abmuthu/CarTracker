package com.muthukumaranpk.repository;

import com.muthukumaranpk.entity.Alert;
import com.muthukumaranpk.entity.Reading;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.hibernate.query.criteria.internal.expression.function.AggregationFunction;
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

    private static int MINUTE = 60 * 1000;

    @PersistenceContext
    private EntityManager entityManager;


    @Override
    public Reading storeReading(Reading reading) {
        entityManager.persist(reading);
        return reading;
    }

    @Override
    public List<Reading> findReadingsInTimeRange(String vin, int timeRange) {
        Session session = entityManager.unwrap(Session.class);
        Query<Reading> query = session.createNamedQuery("Reading.findReadingsOfSingleVehicle", Reading.class);
        query.setParameter("num", vin);
        query.setParameter("timeRange", new Date(System.currentTimeMillis() - timeRange * MINUTE));
        List<Reading> list = query.list();
        return list;
    }
}
