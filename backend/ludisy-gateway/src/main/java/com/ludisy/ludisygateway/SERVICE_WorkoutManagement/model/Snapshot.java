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
public class Snapshot {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "SNAPSHOT_ID")
    private long bikingId;

    @Column(name = "LONGITUDE")
    private double longitude;

    @Column(name = "LATITUDE")
    private double latitude;

    @Column(name = "ALTITUDE")
    private double altitude;

    @Column(name = "SPEED")
    private double speed;

    @Column(name = "WHEN_SEC")
    private int whenSec;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    private Workout workout;
}
