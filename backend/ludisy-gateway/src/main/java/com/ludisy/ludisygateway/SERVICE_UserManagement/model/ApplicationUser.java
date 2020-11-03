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

    @Column(name = "BIRTH_DATE")
    private String birthDate;

    @Column(name = "COUND_DOWN_SEC")
    private Integer coundDownSec;

    @Column(name = "DISPLAY_NAME")
    private String displayName;

    @Column(name = "GENDER")
    private String gender;

    @Column(name = "HEIGHT")
    private Integer height;

    @Column(name = "PHOTO_URL")
    private String photoUrl;

    @Column(name = "WEIGHT")
    private Integer weight;

    @Column(name = "username")
    private String username;

    @Column(name = "password")
    private String password;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "applicationUser", fetch = FetchType.EAGER)
    private List<Workout> workouts = new ArrayList<>();

    public ApplicationUser() {
    }

    public long getApplicationUserId() {
        return applicationUserId;
    }

    public void setApplicationUserId(long applicationUserId) {
        this.applicationUserId = applicationUserId;
    }

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
