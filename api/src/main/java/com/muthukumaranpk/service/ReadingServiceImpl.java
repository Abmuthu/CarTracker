package com.muthukumaranpk.service;

import com.muthukumaranpk.entity.Reading;
import com.muthukumaranpk.repository.ReadingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by muthukumaran on 5/26/17.
 */
@Service
public class ReadingServiceImpl implements ReadingService {

    @Autowired
    private ReadingRepository readingRepository;

    @Override
    @Transactional
    public Reading putReading(Reading reading) {
        return readingRepository.storeReading(reading);
//        System.out.println("Reading test service!!!!!!!!!!!");
//        return null;
    }
}

// get readings from mocker and store it
//
