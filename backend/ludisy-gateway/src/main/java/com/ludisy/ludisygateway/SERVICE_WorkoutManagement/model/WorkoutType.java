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
    private long typeId;

    @Column(name = "TYPE_CODE")
    private int typeCode;

    @Column(name = "TYPE_NAME")
    private String typeName;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "workoutType", fetch = FetchType.LAZY)
    private List<Workout> workouts = new ArrayList<>();

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "workoutType", fetch = FetchType.EAGER)
    private List<WorkoutData> workoutData = new ArrayList<>();


    public WorkoutType() {
    }

    public long getTypeId() {
        return typeId;
    }

    public void setTypeId(long typeId) {
        this.typeId = typeId;
    }

    public int getTypeCode() {
        return typeCode;
    }

    public void setTypeCode(int typeCode) {
        this.typeCode = typeCode;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public List<Workout> getWorkouts() {
        return workouts;
    }

    public void setWorkouts(List<Workout> workouts) {
        this.workouts = workouts;
    }

    public List<WorkoutData> getWorkoutData() {
        return workoutData;
    }

    public void setWorkoutData(List<WorkoutData> workoutData) {
        this.workoutData = workoutData;
    }
}
