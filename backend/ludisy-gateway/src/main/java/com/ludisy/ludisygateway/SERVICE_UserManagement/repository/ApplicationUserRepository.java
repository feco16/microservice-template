package com.ludisy.ludisygateway.SERVICE_UserManagement.repository;

import com.ludisy.ludisygateway.SERVICE_UserManagement.model.ApplicationUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ApplicationUserRepository extends JpaRepository<ApplicationUser, Long> {

    ApplicationUser findByName(String name);
}
