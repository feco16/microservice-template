package com.ludisy.ludisygateway.SERVICE_WorkoutManagement.dto;

import com.fasterxml.jackson.databind.JsonNode;
import org.json.simple.JSONObject;

public class WorkoutDTO {

    private String uuid;
    private int duration;
    private long timeStamp;
    private double cal;
    private int type;
    private JSONObject data;

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public long getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(long timeStamp) {
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

    public void setData(JSONObject data) {
        this.data = data;
    }

    public JSONObject getData() {
        return data;
    }
}
