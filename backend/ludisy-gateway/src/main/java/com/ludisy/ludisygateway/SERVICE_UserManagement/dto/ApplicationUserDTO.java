package com.ludisy.ludisygateway.SERVICE_UserManagement.dto;

import com.ludisy.ludisygateway.SERVICE_WorkoutManagement.dto.WorkoutDTO;

import java.util.List;

public class ApplicationUserDTO {

    private String userId;
    private String birthDate;
    private Integer coundDownSec;
    private String displayName;
    private String gender;
    private Integer height;
    private String photoUrl;
    private Integer weight;
    private String username;
    private String password;
    private List<WorkoutDTO> workouts;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    public Integer getCoundDownSec() {
        return coundDownSec;
    }

    public void setCoundDownSec(Integer coundDownSec) {
        this.coundDownSec = coundDownSec;
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Integer getHeight() {
        return height;
    }

    public void setHeight(Integer height) {
        this.height = height;
    }

    public String getPhotoUrl() {
        return photoUrl;
    }

    public void setPhotoUrl(String photoUrl) {
        this.photoUrl = photoUrl;
    }

    public Integer getWeight() {
        return weight;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
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

    public List<WorkoutDTO> getWorkouts() {
        return workouts;
    }

    public void setWorkouts(List<WorkoutDTO> workouts) {
        this.workouts = workouts;
    }
}
