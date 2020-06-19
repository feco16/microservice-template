package com.ludisy.ludisygateway.SERVICE_UserManagement.repository;

import com.ludisy.ludisygateway.SERVICE_UserManagement.model.ApplicationUser;
import org.springframework.stereotype.Service;

@Service
public class ApplicationUserRepository {

    ApplicationUser applicationUser = new ApplicationUser("user1", "password1");

    public ApplicationUser findByUsername(String username) {
        if (username.equals(applicationUser.getUsername())) {
            return applicationUser;
        }
        return null;
    }
}
