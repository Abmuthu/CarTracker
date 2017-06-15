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
import java.util.List;

/**
 * Created by muthukumaran on 5/26/17.
 */

@Repository
public class ReadingRepositoryImpl implements ReadingRepository {

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
        Query<Reading> query = session.createQuery("from Reading where vin = :num");
        query.setParameter("num", vin);
        List<Reading> list = query.list();
        return list;
    }
}
