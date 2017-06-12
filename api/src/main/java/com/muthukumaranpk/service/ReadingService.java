package com.muthukumaranpk.service;

import com.muthukumaranpk.entity.Reading;

import java.util.List;

/**
 * Created by muthukumaran on 5/26/17.
 */
public interface ReadingService {

    Reading putReading(Reading reading);

    List<Reading> getAllReadingsOfAVehicle(String vin);
}
