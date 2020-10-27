package com.ludisy.ludisygateway.SERVICE_WorkoutManagement.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

@Entity
public class WorkoutData {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "WORKOUT_DATA_ID")
    private long workoutDataId;

    @Column(name = "NAME")
    private String name;

    @Column(name = "IS_DIRECT")
    private boolean isDirect;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    private WorkoutType workoutType;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "workoutData", fetch = FetchType.EAGER)
    private List<DataInstance> dataInstances = new ArrayList<>();

    public WorkoutData() {
    }

    public long getWorkoutDataId() {
        return workoutDataId;
    }

    public void setWorkoutDataId(long workoutDataId) {
        this.workoutDataId = workoutDataId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isDirect() {
        return isDirect;
    }

    public void setDirect(boolean direct) {
        isDirect = direct;
    }

    public WorkoutType getWorkoutType() {
        return workoutType;
    }

    public void setWorkoutType(WorkoutType workoutType) {
        this.workoutType = workoutType;
    }

    public List<DataInstance> getDataInstances() {
        return dataInstances;
    }

    public void setDataInstances(List<DataInstance> dataInstances) {
        this.dataInstances = dataInstances;
    }
}
