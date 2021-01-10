package com.ludisy.ludisygateway.SERVICE_WorkoutManagement.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "DATA_INSTANCE")
@SequenceGenerator(name = "seq_data_instance", sequenceName = "seq_data_instance", allocationSize = 1)
public class DataInstance {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_data_instance")
    @Column(name = "DATA_INSTANCE_ID")
    private long dataInstanceId;

    @Column(name = "VALUE")
    private String value;

    @Column(name = "LIST_INDEX")
    private int listIndex;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    private Workout workout;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.EAGER)
    private WorkoutData workoutData;

    public long getDataInstanceId() {
        return dataInstanceId;
    }

    public void setDataInstanceId(long dataInstanceId) {
        this.dataInstanceId = dataInstanceId;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public int getListIndex() {
        return listIndex;
    }

    public void setListIndex(int listIndex) {
        this.listIndex = listIndex;
    }

    public Workout getWorkout() {
        return workout;
    }

    public void setWorkout(Workout workout) {
        this.workout = workout;
    }

    public WorkoutData getWorkoutData() {
        return workoutData;
    }

    public void setWorkoutData(WorkoutData workoutData) {
        this.workoutData = workoutData;
    }
}
