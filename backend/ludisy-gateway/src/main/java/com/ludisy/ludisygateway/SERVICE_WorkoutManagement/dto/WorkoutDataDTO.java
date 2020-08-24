package com.ludisy.ludisygateway.SERVICE_WorkoutManagement.dto;

import java.util.List;

public class WorkoutDataDTO {

    private int distance;
    private int stairsCount;
    private List<Object> snapShots;

    public int getDistance() {
        return distance;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }

    public int getStairsCount() {
        return stairsCount;
    }

    public void setStairsCount(int stairsCount) {
        this.stairsCount = stairsCount;
    }

    public List<Object> getSnapShots() {
        return snapShots;
    }

    public void setSnapShots(List<Object> snapShots) {
        this.snapShots = snapShots;
    }
}
