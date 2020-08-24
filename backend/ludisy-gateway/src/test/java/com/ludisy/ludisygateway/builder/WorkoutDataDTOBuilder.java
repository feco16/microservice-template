package com.ludisy.ludisygateway.builder;

import com.ludisy.ludisygateway.SERVICE_WorkoutManagement.dto.WorkoutDataDTO;

import java.util.List;

public class WorkoutDataDTOBuilder {

    private int distance;
    private int stairsCount;
    private List<Object> snapShots;

    public WorkoutDataDTOBuilder distance (int distance) {
        this.distance = distance;
        return this;
    }

    public WorkoutDataDTOBuilder stairsCount (int stairsCount) {
        this.stairsCount = stairsCount;
        return this;
    }

    public WorkoutDataDTOBuilder snapShots (List<Object> snapShots) {
        this.snapShots = snapShots;
        return this;
    }

    public WorkoutDataDTO build() {
        WorkoutDataDTO workoutDTO = new WorkoutDataDTO();
        workoutDTO.setDistance(distance);
        workoutDTO.setStairsCount(stairsCount);
        workoutDTO.setSnapShots(snapShots);

        return workoutDTO;
    }

}
