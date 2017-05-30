package com.muthukumaranpk.repository;

import com.muthukumaranpk.entity.Reading;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * Created by muthukumaran on 5/26/17.
 */

@Repository
public class ReadingRepositoryImpl implements ReadingRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Reading storeReading(Reading reading) {
        System.out.println("Reading test repo before!!!!!!!!!!!");
        entityManager.persist(reading);

        System.out.println("Reading test repo after!!!!!!!!!!!");
        return reading;
    }
}