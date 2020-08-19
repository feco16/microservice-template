package com.ludisy.ludisygateway.SERVICE_WorkoutManagement.dto;

public class BikingObject {

    private double longitude;
    private double latitude;
    private double altitude;
    private double speed;
    private int whenSec;

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getAltitude() {
        return altitude;
    }

    public void setAltitude(double altitude) {
        this.altitude = altitude;
    }

    public double getSpeed() {
        return speed;
    }

    public void setSpeed(double speed) {
        this.speed = speed;
    }

    public int getWhenSec() {
        return whenSec;
    }

    public void setWhenSec(int whenSec) {
        this.whenSec = whenSec;
    }
}
