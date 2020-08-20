package com.ludisy.ludisygateway.SERVICE_UserManagement.dto;

import com.ludisy.ludisygateway.SERVICE_WorkoutManagement.model.Workout;

import java.util.List;

public class ApplicationUserDTO {

    private String userId;
    private String username;
    private String password;
    private List<Workout> workouts;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
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
}
