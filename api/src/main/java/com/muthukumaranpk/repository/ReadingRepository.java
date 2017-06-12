package com.muthukumaranpk.repository;

import com.muthukumaranpk.entity.Reading;
import com.muthukumaranpk.entity.Vehicle;

import java.util.List;

/**
 * Created by muthukumaran on 5/26/17.
 */
public interface ReadingRepository {

    Reading storeReading(Reading reading);

    List<Reading> findReadingsOfAVehicle(String vin);
}
