package com.ludisy.ludisygateway.SERVICE_WorkoutManagement.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.ludisy.ludisygateway.SERVICE_UserManagement.model.ApplicationUser;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Workout {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "WORKOUT_ID")
    private long workoutId;

    @Column(name = "UUID")
    private String uuid;

    @Column(name = "DURATION")
    private int duration;

    @Column(name = "TIME_STAMP")
    private long timeStamp;

    @Column(name = "CAL")
    private double cal;

    @Column(name = "TYPE")
    private int type;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    private ApplicationUser applicationUser;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    private WorkoutType workoutType;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "workout", fetch = FetchType.LAZY)
    private List<Snapshot> snapshots = new ArrayList<>();

    @OneToOne(cascade = CascadeType.ALL)
    private WorkoutData workoutData;

    public long getWorkoutId() {
        return workoutId;
    }

    public void setWorkoutId(long workoutId) {
        this.workoutId = workoutId;
    }

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

    public ApplicationUser getApplicationUser() {
        return applicationUser;
    }

    public void setApplicationUser(ApplicationUser applicationUser) {
        this.applicationUser = applicationUser;
    }

    public List<Snapshot> getSnapshots() {
        return snapshots;
    }

    public void setSnapshots(List<Snapshot> snapshots) {
        this.snapshots = snapshots;
    }

    public WorkoutType getWorkoutType() {
        return workoutType;
    }

    public void setWorkoutType(WorkoutType workoutType) {
        this.workoutType = workoutType;
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
        Workout workout = (Workout) o;
        return workoutId == workout.workoutId;
    }

    @Override
    public int hashCode() {
        return 31;
    }
}
