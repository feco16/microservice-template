package com.ludisy.ludisygateway.SERVICE_WorkoutManagement.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.ludisy.ludisygateway.SERVICE_UserManagement.model.ApplicationUser;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "WORKOUT")
@SequenceGenerator(name = "seq_workout", sequenceName = "seq_workout", allocationSize = 1)
public class Workout {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_workout")
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

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    private ApplicationUser applicationUser;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @Fetch(FetchMode.JOIN)
    private WorkoutType workoutType;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "workout", fetch = FetchType.LAZY)
    private List<DataInstance> dataInstances = new ArrayList<>();

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

    public ApplicationUser getApplicationUser() {
        return applicationUser;
    }

    public void setApplicationUser(ApplicationUser applicationUser) {
        this.applicationUser = applicationUser;
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

    public void removeDataInstances() {
        if (dataInstances == null) {
            return;
        }
        dataInstances.stream()
                .forEach(dataInstance -> dataInstance.setWorkout(null));
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
