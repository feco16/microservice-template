package com.ludisy.ludisygateway.SERVICE_WorkoutManagement.model;

import com.ludisy.ludisygateway.SERVICE_UserManagement.model.ApplicationUser;
import com.ludisy.ludisygateway.SERVICE_WorkoutManagement.dto.WorkoutInstance;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Workout {

    @Id
    @Column(name = "WORKOUT_ID")
    private long workoutId;

    @Column(name = "UUID")
    private String uuid;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "APPLICATION_USER_ID")
    private ApplicationUser applicationUser;

    @Column(name = "DURATION")
    private int duration;

    @Column(name = "TIME_STAMP")
    private int timeStamp;

    @Column(name = "CAL")
    private double cal;

//    private WorkoutInstance data;


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

    public ApplicationUser getApplicationUser() {
        return applicationUser;
    }

    public void setApplicationUser(ApplicationUser applicationUser) {
        this.applicationUser = applicationUser;
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

}
