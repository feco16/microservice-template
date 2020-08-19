package com.ludisy.ludisygateway.SERVICE_WorkoutManagement.dto;

public class WorkoutDTO {

    private String id;
    private int duration;
    private int timeStamp;
    private double cal;
    private int type;
    private WorkoutInstance data;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public int getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(int timeStamp) {
        this.timeStamp = timeStamp;
    }

    public double getCal() {
        return cal;
    }

    public void setCal(double cal) {
        this.cal = cal;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public WorkoutInstance getData() {
        return data;
    }

    public void setData(WorkoutInstance data) {
        this.data = data;
    }
}
