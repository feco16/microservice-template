package com.ludisy.ludisygateway.SERVICE_WorkoutManagement.convert;

import com.ludisy.ludisygateway.SERVICE_WorkoutManagement.dto.BikingDTO;
import com.ludisy.ludisygateway.SERVICE_WorkoutManagement.model.Biking;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class BikingConverter  implements Converter<BikingDTO, Biking> {

    @Override
    public Biking convert(BikingDTO source) {
        Biking biking = new Biking();
        biking.setAltitude(source.getAltitude());
        biking.setLatitude(source.getLatitude());
        biking.setLongitude(source.getLongitude());
        biking.setSpeed(source.getSpeed());
        biking.setWhenSec(source.getWhenSec());
        return biking;
    }
}
