package com.ludisy.ludisygateway.builder;

import com.ludisy.ludisygateway.SERVICE_UserManagement.model.ApplicationUser;

public class ApplicationUserBuilder {

    private long applicationUserId;
    private String userId;
    private String birthDate;
    private Integer coundDownSec;
    private String displayName;
    private String gender;
    private Integer height;
    private String photoUrl;
    private Integer weight;
    private String username;

    public ApplicationUserBuilder applicationUserId(long applicationUserId) {
        this.applicationUserId = applicationUserId;
        return this;
    }

    public ApplicationUserBuilder userId(String userId) {
        this.userId = userId;
        return this;
    }

    public ApplicationUserBuilder username(String username) {
        this.username = username;
        return this;
    }

    public ApplicationUser build() {
        ApplicationUser applicationUser = new ApplicationUser();
        applicationUser.setApplicationUserId(applicationUserId);
        applicationUser.setUserId(userId);
        applicationUser.setUsername(username);
        return applicationUser;
    }
}
