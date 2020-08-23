package com.ludisy.ludisygateway.SERVICE_UserManagement.model;

import com.ludisy.ludisygateway.SERVICE_WorkoutManagement.model.Workout;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "APPLICATION_USER")
public class ApplicationUser {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "APPLICATION_USER_ID")
    private long applicationUserId;

    @Column(name = "USER_ID")
    private String userId;

    @Column(name = "username")
    private String username;

    @Column(name = "password")
    private String password;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "applicationUser", fetch = FetchType.LAZY)
    private List<Workout> workouts = new ArrayList<>();

    public ApplicationUser() {
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public ApplicationUser(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public long getApplicationUserId() {
        return applicationUserId;
    }

    public void setApplicationUserId(long applicationUserId) {
        this.applicationUserId = applicationUserId;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Workout> getWorkouts() {
        return workouts;
    }

    public void setWorkouts(List<Workout> workouts) {
        this.workouts = workouts;
    }



    public void addWorkout(Workout workout) {
        workouts.add(workout);
        workout.setApplicationUser(this);
    }

    public void removeWorkout(Workout workout) {
        workouts.remove(workout);
        workout.setApplicationUser(null);
    }
}
