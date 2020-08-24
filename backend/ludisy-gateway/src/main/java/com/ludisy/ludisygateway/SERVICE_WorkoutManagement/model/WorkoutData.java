package com.ludisy.ludisygateway.SERVICE_WorkoutManagement.model;

import org.springframework.stereotype.Component;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

@Entity
public class WorkoutData {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "WORKOUT_DATA_ID")
    private long workoutId;

    @Column(name = "DISTANCE")
    private int distance;

    @Column(name = "STAIRS_COUNT")
    private int stairsCount;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "workoutData", fetch = FetchType.EAGER)
    private List<Biking> bikingList = new ArrayList<>();

    public long getWorkoutId() {
        return workoutId;
    }

    public void setWorkoutId(long workoutId) {
        this.workoutId = workoutId;
    }

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

    public List<Biking> getBikingList() {
        return bikingList;
    }

    public void setBikingList(List<Biking> bikingList) {
        this.bikingList = bikingList;
    }

    public void addBiking(Biking biking) {
        bikingList.add(biking);
        biking.setWorkoutData(this);
    }

}
