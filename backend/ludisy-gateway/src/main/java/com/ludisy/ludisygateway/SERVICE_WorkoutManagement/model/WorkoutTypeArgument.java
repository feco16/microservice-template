package com.ludisy.ludisygateway.SERVICE_WorkoutManagement.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class WorkoutTypeArgument {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "TYPE_ID")
    private long workoutId;

    @Column(name = "UUID")
    private String uuid;

    @Column(name = "NAME")
    private String name;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    private WorkoutType workoutType;

    public WorkoutTypeArgument() {
    }

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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public WorkoutType getWorkoutType() {
        return workoutType;
    }

    public void setWorkoutType(WorkoutType workoutType) {
        this.workoutType = workoutType;
    }
}
