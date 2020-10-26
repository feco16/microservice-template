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
public class TypeArgument {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "TYPE_ARGUMENT_ID")
    private long typeArgumentId;

    @Column(name = "NAME")
    private String name;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    private WorkoutType workoutType;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "typeArgument", fetch = FetchType.EAGER)
    private List<TypeInstance> typeInstances = new ArrayList<>();

    public TypeArgument() {
    }

    public long getTypeArgumentId() {
        return typeArgumentId;
    }

    public void setTypeArgumentId(long typeArgumentId) {
        this.typeArgumentId = typeArgumentId;
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

    public List<TypeInstance> getTypeInstances() {
        return typeInstances;
    }

    public void setTypeInstances(List<TypeInstance> typeInstances) {
        this.typeInstances = typeInstances;
    }
}
