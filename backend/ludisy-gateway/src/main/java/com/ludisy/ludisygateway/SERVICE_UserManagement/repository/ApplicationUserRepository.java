package com.ludisy.ludisygateway.SERVICE_UserManagement.repository;

import com.ludisy.ludisygateway.SERVICE_UserManagement.model.ApplicationUser;
import org.springframework.stereotype.Service;

@Service
public class ApplicationUserRepository {

    // Bcrypt-ed password for password1
    ApplicationUser applicationUser = new ApplicationUser("user1", "$2a$10$ZDSiYI3YKPsqXAsF3PA5zu.2hdr3e5umjBzK2JAkyb2XelKH4Hgpq");

    public ApplicationUser findByUsername(String username) {
        if (username.equals(applicationUser.getUsername())) {
            return applicationUser;
        }
        return null;
    }
}
