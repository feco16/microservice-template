package com.ludisy.ludisygateway.SERVICE_WorkoutManagement.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import java.util.Objects;

@Entity
public class Biking {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "BIKING_ID")
    private long bikingId;

    @Column(name = "LONGITUDE")
    private double longitude;

    @Column(name = "LATITUDE")
    private double latitude;

    @Column(name = "ALTITUDE")
    private double altitude;

    @Column(name = "SPEED")
    private double speed;

    @Column(name = "WHEN_SEC")
    private int whenSec;

    @ManyToOne
    @JsonIgnore
    private WorkoutData workoutData;

    public long getBikingId() {
        return bikingId;
    }

    public void setBikingId(long bikingId) {
        this.bikingId = bikingId;
    }

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

    public WorkoutData getWorkoutData() {
        return workoutData;
    }

    public void setWorkoutData(WorkoutData workoutData) {
        this.workoutData = workoutData;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Biking biking = (Biking) o;
        return bikingId == biking.bikingId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(bikingId);
    }
}
