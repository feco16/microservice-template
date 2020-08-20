package com.ludisy.ludisygateway.SERVICE_UserManagement.model;

import com.ludisy.ludisygateway.SERVICE_WorkoutManagement.model.Workout;
import org.hibernate.jdbc.Work;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "APPLICATION_USER")
public class ApplicationUser {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long applicationUserId;

    @Column(name = "USER_ID")
    private String userId;

    @Column(name = "username")
    private String username;

    @Column(name = "password")
    private String password;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY, mappedBy = "applicationUser")
    private List<Workout> workouts;

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
}
