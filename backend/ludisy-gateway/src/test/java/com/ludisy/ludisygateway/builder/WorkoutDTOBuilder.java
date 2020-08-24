package com.ludisy.ludisygateway.builder;

import com.ludisy.ludisygateway.SERVICE_WorkoutManagement.dto.WorkoutDTO;
import com.ludisy.ludisygateway.SERVICE_WorkoutManagement.dto.WorkoutDataDTO;

public class WorkoutDTOBuilder {

    private String id;
    private int duration;
    private long timeStamp;
    private double cal;
    private int type;
    private WorkoutDataDTO data;

    public WorkoutDTOBuilder id (String id) {
        this.id = id;
        return this;
    }

    public WorkoutDTOBuilder duration (int duration) {
        this.duration = duration;
        return this;
    }

    public WorkoutDTOBuilder type (int type) {
        this.type = type;
        return this;
    }

    public WorkoutDTOBuilder data (WorkoutDataDTO data) {
        this.data = data;
        return this;
    }

    public WorkoutDTO build() {
        WorkoutDTO workoutDTO = new WorkoutDTO();
        workoutDTO.setId(id);
        workoutDTO.setDuration(duration);
        workoutDTO.setType(type);
        workoutDTO.setData(data);

        return workoutDTO;
    }
}
