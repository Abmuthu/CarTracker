package com.muthukumaranpk.service;

import com.muthukumaranpk.entity.Reading;
import com.muthukumaranpk.repository.ReadingRepository;
import com.muthukumaranpk.repository.VehicleRepository;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by muthukumaran on 5/26/17.
 */
@Service
public class ReadingServiceImpl implements ReadingService {

    @Autowired
    private ReadingRepository readingRepository;

    @Autowired
    private VehicleService vehicleService;

    private Set<String> timeStampSet = new HashSet<>();

    @Override
    @Transactional
    public Reading putReading(Reading reading) {
        Reading returnedReading = null;
        if (vehicleService.isVehiclePresent(reading.getVin())) {
            if (timeStampSet.contains(reading.getTimestamp())) {

                System.out.println("Duplicate!!! " + reading);
            } else {
                timeStampSet.add(reading.getTimestamp());
                returnedReading = readingRepository.storeReading(reading);
            }
            // if already visited - if in set : dont do anything
            // if not already vising - if not in set :
        } else {
            // throw exception no associated vehicle
        }

        return returnedReading;
    }
}

