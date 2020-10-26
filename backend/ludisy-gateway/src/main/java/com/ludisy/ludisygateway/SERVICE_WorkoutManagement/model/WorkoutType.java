package com.ludisy.ludisygateway.SERVICE_WorkoutManagement.model;

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
public class WorkoutType {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "TYPE_ID")
    private long workoutId;

    @Column(name = "UUID")
    private String uuid;

    @Column(name = "TYPE")
    private int type;

    @Column(name = "HAS_SNAPSHOTS")
    private boolean hasSnapshots;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "workoutType", fetch = FetchType.LAZY)
    private List<Workout> workouts = new ArrayList<>();

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "workoutType", fetch = FetchType.EAGER)
    private List<WorkoutTypeArgument> workoutTypeArguments = new ArrayList<>();


    public WorkoutType() {
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

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public List<WorkoutTypeArgument> getWorkoutTypeArguments() {
        return workoutTypeArguments;
    }

    public void setWorkoutTypeArguments(List<WorkoutTypeArgument> workoutTypeArguments) {
        this.workoutTypeArguments = workoutTypeArguments;
    }

    public boolean isHasSnapshots() {
        return hasSnapshots;
    }

    public void setHasSnapshots(boolean hasSnapshots) {
        this.hasSnapshots = hasSnapshots;
    }

    public List<Workout> getWorkouts() {
        return workouts;
    }

    public void setWorkouts(List<Workout> workouts) {
        this.workouts = workouts;
    }
}
