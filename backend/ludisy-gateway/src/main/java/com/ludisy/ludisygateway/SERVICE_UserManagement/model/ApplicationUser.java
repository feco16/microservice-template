package com.ludisy.ludisygateway.SERVICE_UserManagement.model;

public class ApplicationUser {

    String username;

    String password;

    public String getUsername() {
        return username;
    }

    public ApplicationUser(String username, String password) {
        this.username = username;
        this.password = password;
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
}
