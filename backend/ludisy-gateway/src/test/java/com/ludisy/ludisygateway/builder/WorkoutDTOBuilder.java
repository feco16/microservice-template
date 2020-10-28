package com.ludisy.ludisygateway.builder;

import com.ludisy.ludisygateway.SERVICE_WorkoutManagement.dto.WorkoutDTO;
import org.json.simple.JSONObject;

public class WorkoutDTOBuilder {

    private String uuid;
    private int duration;
    private long timeStamp;
    private double cal;
    private int type;
    private JSONObject data;

    public WorkoutDTOBuilder uuid (String uuid) {
        this.uuid = uuid;
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

    public WorkoutDTOBuilder data (JSONObject data) {
        this.data = data;
        return this;
    }

    public WorkoutDTO build() {
        WorkoutDTO workoutDTO = new WorkoutDTO();
        workoutDTO.setUuid(uuid);
        workoutDTO.setDuration(duration);
        workoutDTO.setType(type);
        workoutDTO.setData(data);

        return workoutDTO;
    }
}
