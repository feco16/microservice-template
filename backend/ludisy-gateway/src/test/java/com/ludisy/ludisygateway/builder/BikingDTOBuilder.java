package com.ludisy.ludisygateway.builder;

import com.ludisy.ludisygateway.SERVICE_WorkoutManagement.dto.BikingDTO;
import com.ludisy.ludisygateway.TestUtils;

public class BikingDTOBuilder {

    private double longitude;
    private double latitude;
    private double altitude;
    private double speed;
    private int whenSec;

    public BikingDTOBuilder longitude (double longitude) {
        this.longitude = longitude;
        return this;
    }

    public BikingDTOBuilder latitude (double latitude) {
        this.latitude = latitude;
        return this;
    }

    public BikingDTO build () {
        BikingDTO bikingDTO = new BikingDTO();

        bikingDTO.setLongitude(TestUtils.getRandomDouble());
        bikingDTO.setLatitude(TestUtils.getRandomDouble());
        bikingDTO.setAltitude(TestUtils.getRandomDouble());
        bikingDTO.setSpeed(TestUtils.getRandomDouble());
        bikingDTO.setWhenSec(TestUtils.getRandomInt());

        return bikingDTO;
    }


}
