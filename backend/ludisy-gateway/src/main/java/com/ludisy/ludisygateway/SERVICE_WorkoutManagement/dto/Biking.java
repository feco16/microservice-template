package com.ludisy.ludisygateway.SERVICE_WorkoutManagement.dto;

import java.util.List;

public class Biking extends WorkoutInstance{

    private int distance;
    private List<BikingObject> snapShots;

    public int getDistance() {
        return distance;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }

    public List<BikingObject> getSnapShots() {
        return snapShots;
    }

    public void setSnapShots(List<BikingObject> snapShots) {
        this.snapShots = snapShots;
    }
}
